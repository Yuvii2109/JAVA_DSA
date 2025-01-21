// Path With Minimum Effort
// We have a two-dimensional grid, each cell of which contains an integer 
// cost which represents a cost to traverse through that cell, we need to 
// find a path from the top left cell to the bottom right cell by which 
// the total cost incurred is minimum.
// Sample Input 1 -
// { { 31, 100, 65, 12, 18 },
// { 10, 13, 47, 157, 6 },
// { 100, 113, 174, 11, 33 },
// { 88, 124, 41, 20, 140 },
// { 99, 32, 111, 41, 20 } }
// Sample Output 1 - 327 (= 31 + 10 + 13 + 47 + 65 + 12 + 18 + 6 + 33 + 11 + 20 + 41 + 20)

import java.util.PriorityQueue;

public class PathWithMinEffort {
    static class Cell implements Comparable<Cell> {
        int row, col, cost;

        Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cell other) {
            return this.cost - other.cost; // Min-heap based on cost
        }
    }

    public static int findMinCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Directions for moving up, down, left, right
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // Priority queue for processing cells in order of cost
        PriorityQueue<Cell> pq = new PriorityQueue<>();

        // Visited array to avoid revisiting cells
        boolean[][] visited = new boolean[rows][cols];

        // Add the top-left corner to the priority queue
        pq.add(new Cell(0, 0, grid[0][0]));

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int x = current.row;
            int y = current.col;
            int cost = current.cost;

            // If we've reached the bottom-right corner, return the cost
            if (x == rows - 1 && y == cols - 1) {
                return cost;
            }

            // Mark the current cell as visited
            if (visited[x][y]) continue;
            visited[x][y] = true;

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // Check bounds and if the neighbor is not yet visited
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                    // Add the neighbor to the queue with its cumulative cost
                    pq.add(new Cell(newX, newY, cost + grid[newX][newY]));
                }
            }
        }

        // If no path is found, return -1 (should not happen for a valid grid)
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {31, 100, 65, 12, 18},
                {10, 13, 47, 157, 6},
                {100, 113, 174, 11, 33},
                {88, 124, 41, 20, 140},
                {99, 32, 111, 41, 20}
        };

        System.out.println("Minimum cost - " + findMinCost(grid));
    }
}

// Time complexity - O(R*C.log(R*C))
// Space complexity - O(R*C) for the priority queue and visited matrix