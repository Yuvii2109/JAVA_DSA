/*
    Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

    The distance between two cells sharing a common edge is 1.

    Example 1 -
        Input - mat = [[0,0,0],[0,1,0],[0,0,0]]
        Output - [[0,0,0],[0,1,0],[0,0,0]]

    Example 2 -
        Input - mat = [[0,0,0],[0,1,0],[1,1,1]]
        Output - [[0,0,0],[0,1,0],[1,2,1]]
*/

import java.util.Queue;
import java.util.LinkedList;

public class 01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int dist[][] = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // Initialize distances and queue:
        // If cell is 0, its distance is 0 and we enqueue it.
        // If cell is 1, mark its distance as -1 (unvisited).
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int cell[] = queue.poll();
            int x = cell[0], y = cell[1];
            for(int[] dir : dirs){
                int nx = x + dir[0], ny = y + dir[1];
                // If neighbor is inbound and unvisited (dist == -1), then its distance is current dist + 1.
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && dist[nx][ny] == -1){
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return dist;
    }
}