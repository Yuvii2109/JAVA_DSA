/*
    Given an m x n integers matrix, return the length of the longest increasing path in matrix. From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed). 

    Example 1 -
        Input - matrix = [[9,9,4],[6,6,8],[2,1,1]]
        Output - 4
        Explanation - The longest increasing path is [1, 2, 6, 9].

    Example 2 -
        Input - matrix = [[3,4,5],[3,2,6],[2,2,1]]
        Output - 4
        Explanation - The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

    Example 3 - 
        Input - matrix = [[1]]
        Output - 1
*/

public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxPath = 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                maxPath = Math.max(maxPath, dfs(matrix, dp, i, j));
            }
        }
        return maxPath;
    }

    // Directions for moving up, down, left, and right
    private static final int[][] DIRS = {
        {1, 0},  // down
        {-1, 0}, // up
        {0, 1},  // right
        {0, -1}  // left
    };

    private int dfs(int[][] matrix, int[][] dp, int row, int col){
        if(dp[row][col] != 0){
            return dp[row][col]; // Already computed
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int longest = 1; // At minimum, the path includes the current cell

        // Explore all 4 directions - 
        for(int[] dir : DIRS){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && matrix[newRow][newCol] > matrix[row][col]){
                int len = 1 + dfs(matrix, dp, newRow, newCol);
                longest = Math.max(longest, len);
            }
        }
        dp[row][col] = longest;
        return longest;
    }
}