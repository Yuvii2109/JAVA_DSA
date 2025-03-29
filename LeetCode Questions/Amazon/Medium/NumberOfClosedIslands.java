/*
    Given a 2D grid consists of 0s (land) and 1s (water).  An island is a 
    maximal 4-directionally connected group of 0s and a closed island is 
    an island totally (all left, top, right, bottom) surrounded by 1s.
    Return the number of closed islands. 

    Example 1 - 
        Input - grid = [[1,1,1,1,1,1,1,0],
                       [1,0,0,0,0,1,1,0],
                       [1,0,1,0,1,1,1,0],
                       [1,0,0,0,0,1,0,1],
                       [1,1,1,1,1,1,1,0]]
        Output - 2
        Explanation - Islands in gray are closed because they are completely surrounded by water (group of 1s).

    Example 2 -
        Input - grid = [[0,0,1,0,0],
                       [0,1,0,1,0],
                       [0,1,1,1,0]]
        Output - 1

    Example 3 -
        Input - grid = [[1,1,1,1,1,1,1],
                       [1,0,0,0,0,0,1],
                       [1,0,1,1,1,0,1],
                       [1,0,1,0,1,0,1],
                       [1,0,1,1,1,0,1],
                       [1,0,0,0,0,0,1],
                       [1,1,1,1,1,1,1]]
        Output - 2
*/

public class NumberOfClosedIslands {
    public static void dfs(int[][] grid, boolean[][] visited, int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] != 0){
            return;
        }
        visited[i][j] = true;

        // Explore all the directions - 
        dfs(grid, visited, i-1, j, n, m);
        dfs(grid, visited, i+1, j, n, m);
        dfs(grid, visited, i, j-1, n, m);
        dfs(grid, visited, i, j+1, n, m);
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i = 0; i < n; i++){
            // Check 1st and last column in every row
            if(grid[i][0] == 0 && !visited[i][0]){
                dfs(grid, visited, i, 0, n, m);
            }
            if(grid[i][m-1] == 0 && !visited[i][m-1]){
                dfs(grid, visited, i, m-1, n, m);
            }
        }
        for(int j = 0; j < m; j++){
            // Check 1st and last row in every column
            if(grid[0][j] == 0 && !visited[0][j]){
                dfs(grid, visited, 0, j, n, m);
            }
            if(grid[n-1][j] == 0 && !visited[n-1][j]){
                dfs(grid, visited, n-1, j, n, m);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    count++;
                    dfs(grid, visited, i, j, n, m);
                }
            }
        }
        return count;
    }
}