/*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

    Note - You can only move either down or right at any point in time.

    Example 1 -
        Input - grid = [[1,3,1],[1,5,1],[4,2,1]]
        Output - 7
        Explanation - Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

    Example 2 -
        Input - grid = [[1,2,3],[4,5,6]]
        Output - 12
*/

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j] will hold the min path sum to reach cell (i, j)
        int dp[][] = new int[m][n];

        // Initialize the starting point -
        dp[0][0] = grid[0][0];

        // First row can only come from the left
        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // First column can only come from up
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                // We can come either from the top (i-1, j) or left (i, j-1)
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}