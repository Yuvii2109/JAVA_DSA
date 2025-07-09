/*
    Given an m x n matrix, return all elements of the matrix in spiral order.

    Example 1 -
        Input - matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output - [1,2,3,6,9,8,7,4,5]

    Example 2 -
        Input - matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        Output - [1,2,3,4,8,12,11,10,9,5,6,7]
*/

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while(startRow <= endRow && startCol <= endCol){
            // Top
            for(int j = startCol; j <= endCol; j++){
                list.add(matrix[startRow][j]);
            }
            // Right
            for(int i = startRow+1; i <= endRow; i++){
                list.add(matrix[i][endCol]);
            }
            // Bottom
            for(int j = endCol-1; j >= startCol; j--){
                if(startRow == endRow){
                    break;
                }
                list.add(matrix[endRow][j]);
            }
            // Left
            for(int i = endRow-1; i > startRow; i--){
                if(startCol == endCol){
                    break;
                }
                list.add(matrix[i][startCol]);
            }
            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }
        return list;
    }
}