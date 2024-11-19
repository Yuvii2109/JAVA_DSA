public class Sudoku {
    public static boolean isSafe(int sudoku[][], int row, int column, int digit){
        // Checking the row
        for(int x = 0; x < 9; x++){
            if(sudoku[row][x] == digit){
                return false;
            }
        }

        // Checking the column
        for(int x = 0; x < 9; x++){
            if(sudoku[x][column] == digit){
                return false;
            }
        }

        // Checking for the 3x3 grid
        int startRow = row - row % 3; // or - (row/3)*3
        int startColumn = column - column % 3; // or - (column/3)*3
        for(int i = startRow; i < startRow+3; i++){
            for(int j = startColumn; j < startColumn+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int sudoku[][], int row, int column){
        if(row == 9 && column == 0){
            return true;
        }
        
        int nextRow = row, nextColumn = column + 1;

        if (nextColumn == 9) {
            nextColumn = 0;
            nextRow++;
        }

        if(sudoku[row][column] != 0){
            return sudokuSolver(sudoku, nextRow, nextColumn);
        }

        for(int digit = 1; digit <= 9; digit++){
            if(isSafe(sudoku, row, column, digit)){
                sudoku[row][column] = digit;
                if(sudokuSolver(sudoku, nextRow, nextColumn)){
                    return true;
                }
                sudoku[row][column] = 0;
            }
        }
        return false;
    }
    public static void printSudoku(int sudoku[][]){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int sudoku[][] = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0}, 
            {4, 9, 0, 1, 5, 7, 0, 0, 2}, 
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0}, 
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };
        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("\nSolution exists - ");
            printSudoku(sudoku);
            System.out.println();
        }else{
            System.out.println("\nSolution does not exist");
        }
    }
}