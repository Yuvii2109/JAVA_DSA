/*
    Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

    Example 1 -
        Input - matrix = [
        ["1","0","1","0","0"],
        ["1","0","1","1","1"],
        ["1","1","1","1","1"],
        ["1","0","0","1","0"]]
        Output - 6
        Explanation - The maximal rectangle is shown in the above picture.

    Example 2 -
        Input - matrix = [["0"]]
        Output - 0

    Example 3 -
        Input - matrix = [["1"]]
        Output - 1
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int maxArea = 0;
        // heights[j] will be the "histogram height" at column j
        int[] heights = new int[col];
        for(int i = 0; i < row; i++){
            // Update histogram heights based on the current row
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            // Compute largest rectangle for this histogram
            maxArea = Math.max(maxArea, largestRectangle(heights));
        }
        return maxArea;
    }
    // Standard O(n) stack-based algorithm for largest rectangle in histogram
    private int largestRectangle(int[] heights){
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0; i <= n; i++){
            // Use a sentinel height = 0 at the end to flush out remaining bars
            int h = (i == n ? 0 : heights[i]);
            // While current bar is lower than the bar at stack-top, pop and calculate area
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width;
                if(stack.isEmpty()){
                    width = i; // Everything to the left is taller, so width = i
                }else{
                    // Width spans between the new stack-top and current index
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}