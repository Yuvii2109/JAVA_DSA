// We are given N points in a 2D plane which are locations of N cars.
// If we are at the origin, print the nearest K cars.

import java.util.*;

public class NearbyCars {
    public static class Point implements Comparable<Point>{
        int x, y, distance;
        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        @Override
        public int compareTo(Point z){
            return this.distance - z.distance;
        }
    }
    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int distance = x*x + y*y;
            pq.add(new Point(x, y, distance));
        }

        // Nearest k cars -
        for(int i = 0; i < k; i++){
            Point p = pq.poll();
            System.out.println("Car(" + p.x + ", " + p.y + ")");
        }
    }
}