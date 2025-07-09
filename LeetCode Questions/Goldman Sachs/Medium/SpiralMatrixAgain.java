// Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

// Example 1 -
// Input - n = 3
// Output - [[1,2,3],[8,9,4],[7,6,5]]

// Example 2 -
// Input - n = 1
// Output - [[1]]

public class SpiralMatrixAgain {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startRow = 0;
        int endRow = n-1;
        int startCol = 0;
        int endCol = n-1;
        int num = 1;
        while(startRow <= endRow && startCol <= endCol){
            // Top
            for(int j = startCol; j <= endCol; j++){
                matrix[startRow][j] = num++;
            }
            startRow++;
            // Right
            for(int i = startRow; i <= endRow; i++){
                matrix[i][endCol] = num++;
            }
            endCol--;
            // Bottom
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    matrix[endRow][j] = num++;
                }
                endRow--;
            }
            // Left
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    matrix[i][startCol] = num++;
                }
                startCol++;
            }
        }
        return matrix;
    }
}