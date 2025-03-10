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