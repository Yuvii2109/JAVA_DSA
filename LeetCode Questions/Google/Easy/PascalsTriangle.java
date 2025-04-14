/*
    Given an integer numRows, return the first numRows of Pascal's triangle. In Pascal's triangle, each number is the sum of the two numbers directly above it as shown -  

    Example 1 -
        Input - numRows = 5
        Output - [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    Example 2 -
        Input - numRows = 1
        Output - [[1]]
*/

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        // First row is always 1
        if(numRows <= 0) return triangle;
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    // First and last element of each row is always 1
                    row.add(1);
                }else{
                    // Summing the 2 numbers above
                    row.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}