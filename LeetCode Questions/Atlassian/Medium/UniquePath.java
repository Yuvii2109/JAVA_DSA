/*
    You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

    An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

    Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

    The testcases are generated so that the answer will be less than or equal to 2 * 109.

    Example 1 - 
        Input - obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        Output - 2
        Explanation - There is one obstacle in the middle of the 3x3 grid above.
            There are two ways to reach the bottom-right corner:
            1. Right -> Right -> Down -> Down
            2. Down -> Down -> Right -> Right

    Example 2 -
        Input - obstacleGrid = [[0,1],[0,0]]
        Output - 1
*/

public class UniquePath{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // dp[i][j] will hold the number of ways to reach cell (i, j)
        int[][] dp = new int[m][n];

        // If the starting cell has obstacle.. there're no paths
        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        // Initialize the start
        dp[0][0] = 1;
        
        // Fill the first column - can only come from above.
        for (int i = 1; i < m; i++) {
            // If current cell is free AND the cell above had a path, inherit that path count.
            dp[i][0] = (obstacleGrid[i][0] == 0) ? dp[i-1][0] : 0;
        }

        // Fill the first row - can only come from the left.
        for (int j = 1; j < n; j++) {
            // If current cell is free AND the cell to the left had a path, inherit that path count.
            dp[0][j] = (obstacleGrid[0][j] == 0) ? dp[0][j-1] : 0;
        }

        // Now fill the rest of the grid.
        // For each cell (i, j), if it's not an obstacle, the total paths to (i, j) is the sum of paths to the cell above it and to the cell to its left.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else {
                    dp[i][j] = 0; // If there's an obstacle, no paths can go through here.
                }
            }
        }
        // The bottom-right cell holds the total number of unique paths.
        return dp[m-1][n-1];
    }
}