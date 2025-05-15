/*
    You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

    An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

    You may change 0's to 1's to connect the two islands to form one island.

    Return the smallest number of 0's you must flip to connect the two islands. 

    Example 1 -
        Input - grid = [[0,1],[1,0]]
        Output - 1

    Example 2 -
        Input - grid = [[0,1,0],[0,0,0],[0,0,1]]
        Output - 2

    Example 3 -
        Input - grid = [
            [1,1,1,1,1],
            [1,0,0,0,1],
            [1,0,1,0,1],
            [1,0,0,0,1],
            [1,1,1,1,1]
        ]
        Output - 1
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestBridge {
    // Directions for exploring up, down, left, right
    private static final int[][] DIRS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean found = false;
        Deque<int[]> q = new ArrayDeque<>();
        // Find the first island and mark it (change 1 → 2), collect its cells into queue
        for(int i = 0; i < n && !found; i++){
            for(int j = 0; j < n && !found; j++){
                if(grid[i][j] == 1){
                    dfsMark(grid, i, j, q);
                    found = true;
                }
            }
        }
        // BFS from all marked island cells, expanding outwards over zeros
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            // Process 1 layer of expansion - flipping one more 0 → 1
            for(int k = 0; k < size; k++){
                int[] cell = q.poll();
                for(int[] d : DIRS){
                    int ni = cell[0] + d[0];
                    int nj = cell[1] + d[1];
                    // Skip if out of bounds
                    if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
                    // If we hit an unmarked land cell, that's the other island...
                    if (grid[ni][nj] == 1) {
                        return steps;
                    }
                    // If it's water, mark it as visited (2) and enqueue for next layer
                    if (grid[ni][nj] == 0) {
                        grid[ni][nj] = 2;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
            steps++;
        }
        return -1; // By problem statement, there are exactly two islands, so we should never get here.
    }
    // DFS to mark the first island 1 → 2, and collect its cells into queue
    private void dfsMark(int[][] grid, int i , int j, Deque<int[]> queue){
        int n = grid.length;
        // Boundary check and only proceed on land (1)
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }
        // Mark the cell and add to queue
        grid[i][j] = 2;
        queue.offer(new int[]{i, j});
        // Explore all four directions
        for (int[] d : DIRS) {
            dfsMark(grid, i + d[0], j + d[1], queue);
        }
    }
}