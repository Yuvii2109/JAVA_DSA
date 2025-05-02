/*
    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

    Example 1 -
        Input - heights = [2,1,5,6,2,3]
        Output - 10
        Explanation - The above is a histogram where width of each bar is 1. The largest rectangle is shown in the red area, which has an area = 10 units.

    Example 2 -
        Input - heights = [2,4]
        Output - 4
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        // We go from i = 0 to n. At i == n we use height = 0 to flush out any remaining bars in the stack.
        for(int i = 0; i <= n; i++){
            // When i == n we treat height as 0 to clear the stack at the end
            int h = (i == n ? 0 : heights[i]);
            // If current bar is lower than the bar at stack’s top, pop & compute area
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                int height = heights[stack.pop()];
                // Width of rectangle with 'height' as the shortest bar - If stack is empty, it extends from 0 to i−1 -> width = i. Otherwise, it extends from (stack.peek()+1) to (i−1) -> width = i − stack.peek() − 1
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
            }
            // Push current index so heights[stack] is always increasing
            stack.push(i);
        }
        return maxArea;
    }
}