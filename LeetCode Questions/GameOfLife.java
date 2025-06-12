/*
    According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

    The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article) -

        1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
        2. Any live cell with two or three live neighbors lives on to the next generation.
        3. Any live cell with more than three live neighbors dies, as if by over-population.
        4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

    The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

    Given the current state of the board, update the board to reflect its next state.

    Note that you do not need to return anything. 

    Example 1 -
        Input - board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
        Output - [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

    Example 2 -
        Input - board = [[1,1],[1,0]]
        Output - [[1,1],[1,1]]
*/

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // First pass - determine next state, but encode transitions in-place -
        // 0 → 1 - mark as 2
        // 1 → 0 - mark as -1
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int liveNeighbors = countLive(board, i, j, m, n);
                if(board[i][j] == 1 && 
                (liveNeighbors < 2 || liveNeighbors > 3)){
                    board[i][j] = -1; // Dies due to under-population
                }
                if(board[i][j] == 0 && liveNeighbors == 3){
                    board[i][j] = 2; // Reproduces
                }
                // Live cell with 2 or 3 neighbors → stays live - do nothing
                // Dead cell with not exactly 3 neighbors stays dead - do nothing
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] > 0){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }
    }
    private int countLive(int[][] board, int row, int column, int m, int n){
        int count = 0;
        // Eight directions - (−1,−1), (−1,0), (−1,1), (0,−1), (0,1), (1,−1), (1,0), (1,1)
        for(int directRow = -1; directRow <= 1; directRow++){
            for(int directCol = -1; directCol <= 1; directCol++){
                if(directRow == 0 && directCol == 0){
                    continue; // Skip self
                }
                int r = row + directRow;
                int c = column + directCol;
                if(r < 0 || r >= m || c < 0 || c >= n){
                    continue;
                }
                // Original live states are 1 or -1 (marked dying cells as -1)
                if(board[r][c] == 1 || board[r][c] == -1){
                    count++;
                }
            }
        }
        return count;
    }
}