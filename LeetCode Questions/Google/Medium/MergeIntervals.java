/*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

    Example 1 -
        Input - intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output - [[1,6],[8,10],[15,18]]
        Explanation - Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

    Example 2 -
        Input - intervals = [[1,4],[4,5]]
        Output - [[1,5]]
        Explanation - Intervals [1,4] and [4,5] are considered overlapping.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        for(int[] interval : intervals){
            // If the list is empty or the current interval doesn't overlap with the previous interval 
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]){
                merged.add(interval);
            }else{
                // Merge the intervals by updating the ends of the last interval
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}