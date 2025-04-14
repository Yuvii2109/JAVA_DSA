/*
    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle. In Pascal's triangle, each number is the sum of the two numbers directly above it as shown - 

    Example 1 -
        Input - rowIndex = 3
        Output - [1,3,3,1]

    Example 2 -
        Input - rowIndex = 0
        Output - [1]

    Example 3 -
        Input - rowIndex = 1
        Output - [1,1]
*/

import java.util.ArrayList;
import java.util.List;

public class KthRowOfPascalsTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int i = 1; i <= rowIndex; i++){
            // Adding a dummy element at the end. This ensures our list has the proper size (i+1 elements for the current row).
            row.add(0);
            // Update from right to left
            for(int j = i; j > 0; j--){
                row.set(j, row.get(j) + row.get(j-1));
            }
        }
        return row;
    }
}

/*
    Initialization - row = [1]

    Iteration i = 1 -
        Before inner loop - Add dummy 0 → row = [1, 0]
        Inner loop (from j = 1 to 1) -
            j = 1 - Update row[1] = row[1] + row[0] = 0 + 1 = 1
        Result after iteration - row = [1, 1]

    Iteration i = 2 -
        Before inner loop - Add dummy 0 → row = [1, 1, 0]
        Inner loop (from j = 2 down to 1) -
            j = 2 - Update row[2] = row[2] + row[1] = 0 + 1 = 1
            j = 1 - Update row[1] = row[1] + row[0] = 1 + 1 = 2
        Result after iteration - row = [1, 2, 1]

    Iteration i = 3 -
        Before inner loop - Add dummy 0 → row = [1, 2, 1, 0]
        Inner loop (from j = 3 down to 1) -
            j = 3 - Update row[3] = row[3] + row[2] = 0 + 1 = 1
            j = 2 - Update row[2] = row[2] + row[1] = 1 + 2 = 3
            j = 1 - Update row[1] = row[1] + row[0] = 2 + 1 = 3
        Result after iteration - row = [1, 3, 3, 1]
*/