public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9]; // To validate a row
        boolean[][] cols = new boolean[9][9]; // To validate a column
        boolean[][] boxes = new boolean[9][9]; // To validate a 3x3 box

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue; // Skip empty cells
                }

                int num = board[row][col] - '1'; // Convert '1'-'9' to 0-8 index
                int boxIndex = (row / 3) * 3 + (col / 3); // Calculate 3x3 box index

                // Check if the number is already present in the row, column, or box
                if (rows[row][num] || cols[col][num] || boxes[boxIndex][num]) {
                    return false; // Invalid Sudoku
                }

                // Mark the number as seen in row, column, and box
                rows[row][num] = true;
                cols[col][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true; // Valid Sudoku
    }
}