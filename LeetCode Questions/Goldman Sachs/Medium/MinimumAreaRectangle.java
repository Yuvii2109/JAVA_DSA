/*
    You are given an array of points in the X-Y plane points where points[i] = [xi, yi].

    Return the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes. If there is not any such rectangle, return 0.

    Example 1 -
        Input - points = [[1,1],[1,3],[3,1],[3,3],[2,2]]
        Output - 4

    Example 2 -
        Input - points = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
        Output - 2
*/

import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        for(int[] point : points){
            pointSet.add(point[0] + "," + point[1]);
        }
        int minArea = Integer.MAX_VALUE;
        int n = points.length;
        for(int i = 0; i < n; i++){
            int x1 = points[i][0], y1 = points[i][1];
            for(int j = i + 1; j < n; j++){
                int x2 = points[j][0], y2 = points[j][1];
                if(x1 != x2 && y1 != y2){
                    if(pointSet.contains(x1 + "," + y2) &&
                    pointSet.contains(x2 + "," + y1)){
                        int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}