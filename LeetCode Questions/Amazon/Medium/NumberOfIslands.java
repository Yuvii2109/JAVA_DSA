/*
    Given an m x n 2D binary grid grid which represents a map of '1's 
    (land) and '0's (water), return the number of islands. An island is 
    surrounded by water and is formed by connecting adjacent lands 
    horizontally or vertically. You may assume all four edges of the grid 
    are all surrounded by water. 

    Example 1 -
        Input - grid = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
        ]
        Output - 1

    Example 2 -
        Input - grid = [
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]
        ]
        Output - 3
*/

public class NumberOfIslands {
    public static void dfs(char[][] grid, int i, int j, int row, int col){
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0'; // Marking as visited
        dfs(grid, i-1, j, row, col); // Up
        dfs(grid, i+1, j, row, col); // Down
        dfs(grid, i, j-1, row, col); // Left
        dfs(grid, i, j+1, row, col); // Right 
    }
    public int numIslands(char[][] grid) {
        int row = grid.length; 
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }
}