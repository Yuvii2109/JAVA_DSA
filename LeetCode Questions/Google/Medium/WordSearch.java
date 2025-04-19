/*
    Given an m x n grid of characters board and a string word, return true if word exists in the grid. The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

    Example 1 -
        Input - board = [
            ["A","B","C","E"],
            ["S","F","C","S"],
            ["A","D","E","E"]
        ], word = "ABCCED"
        Output - true

    Example 2 -
        Input - board = [
            ["A","B","C","E"],
            ["S","F","C","S"],
            ["A","D","E","E"]
        ], word = "SEE"
        Output - true

    Example 3 -
        Input - board = [
            ["A","B","C","E"],
            ["S","F","C","S"],
            ["A","D","E","E"]
        ], word = "ABCB"
        Output - false
*/

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // Try to start the word from every cell in the grid
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, word, 0, i, j, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited){
        // If we've matched all letters, success...
        if(index == word.length()){
            return true;
        }

        // Check bounds, whether this cell is already used, or the letter mismatches
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }
        // Mark this cell as visited
        visited[i][j] = true;
        // Explore all four directions - right, down, left, up
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        for(int d = 0; d < 4; d++){
            if(dfs(board, word, index+1, i+di[d], j+dj[d], visited)){
                return true;
            }
        }
        // Backtrack - unmark the cell so other paths can use it
        visited[i][j] = false;
        return false;
    }
}