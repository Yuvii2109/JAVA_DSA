// Minimum time required to rot all oranges. We have a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning - 
// 0 - Empty cell 
// 1 - Cells have fresh oranges 
// 2 - Cells have rotten oranges
// We have to determine what is the minimum time required so that all the oranges become rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). If it is impossible to rot every orange then simply return -1. 

// Input - arr[][C] = 
// {{2, 1, 0, 2, 1},
//  {0, 0, 1, 2, 1},
//  {1, 0, 0, 2, 1}};
// Output - All oranges cannot be rotten.

// Explanation -
// At 0th time frame -
// {2, 1, 0, 2, 1}
// {0, 0, 1, 2, 1}
// {1, 0, 0, 2, 1}
// At 1st time frame -
// {2, 2, 0, 2, 2}
// {0, 0, 2, 2, 2}
// {1, 0, 0, 2, 2}
// At 2nd time frame -
// {2, 2, 0, 2, 2}
// {0, 0, 2, 2, 2}
// {1, 0, 0, 2, 2}
// ...
// The 1 at the bottom left corner of the matrix is never rotten.

import java.util.*;

public class RottenOrange {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        // rows and cols store the dimensions of the matrix. queue (a LinkedList<int[]>) is used for Breadth-First Search (BFS). It will store the positions of rotten oranges (2), which will help in spreading the rot. freshOranges keeps track of how many fresh oranges (1) exist. If this count becomes 0 at any point, we know all oranges have rotted.
        
        // Initialize the queue with all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    freshOranges++;
            }
        }
        // The code iterates through each cell of the grid. If the cell contains 2 (rotten orange) - Its position [i, j] is added to queue. If the cell contains 1 (fresh orange) - We increase freshOranges count. Why? The queue will help track which oranges are already rotten and spread their rot level by level using BFS. The count of fresh oranges helps us determine whether all oranges get rotten or not. 
        
        // If there are no fresh oranges, return 0
        if (freshOranges == 0){
            // If there are no fresh oranges initially, then there is no need to rot anything. The function immediately returns 0 because no time is needed.
            return 0;
        }
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;
        // directions is an array of coordinate shifts that allows moving - Up (-1, 0), Down (1, 0), Left (0, -1), Right (0, 1). Why? Since each rotten orange can affect adjacent fresh oranges only in four directions, this array simplifies checking neighbors.
        
        // BFS to rot oranges
        while (!queue.isEmpty()){
            minutes++;
            int size = queue.size();
            // The BFS loop runs while the queue is not empty. Each cycle represents one time unit (minutes). size = queue.size() stores the number of rotten oranges in the current level. Why? Each iteration represents one time frame where the rot spreads.
            
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                // This for loop processes all rotten oranges from the previous time frame. queue.poll() removes and retrieves an orange from the queue. Why? Each rotten orange in the queue is checked and spreads rot to adjacent fresh oranges.
                
                for (int[] dir : directions){
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    // We take one rotten orange's position [current[0], current[1]]. Using the directions array, we compute the new row and column coordinates [x, y] for each adjacent cell. Why? To check in all four possible directions efficiently.
                    
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        // Mark the orange as rotten and add to queue
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        freshOranges--;
                    }
                    // The if condition ensures - The cell [x, y] is inside the matrix (x and y are within valid bounds). The cell contains a fresh orange (1). If a fresh orange is found - It turns rotten (grid[x][y] = 2). Its position is added to the queue to spread rot in the next time frame. Decrease freshOranges count. Why? This spreads the rot in all four directions for every rotten orange. The BFS ensures that oranges rot level by level (minimum time required is counted).
                }
            }
        }
        
        // After BFS, if there are still fresh oranges left, return -1
        return freshOranges == 0 ? minutes - 1 : -1;
        // If all fresh oranges are rotten (freshOranges == 0), return minutes - 1 - We subtract 1 because the last iteration of BFS ran when there were no more fresh oranges left. If there are still fresh oranges left, return -1. Why? If fresh oranges remain, it is impossible to rot all oranges, so -1 is returned.
    }
    
    public static void main(String[] args) {
        RottenOrange solution = new RottenOrange();
        
        // Example usage:
        int[][] grid = {
            {2, 1, 0, 2, 1},
            {0, 0, 1, 2, 1},
            {1, 0, 0, 2, 1}
        };
        
        int result = solution.orangesRotting(grid);
        if(result == -1){
            System.out.println("No oranges can be rotten.");
        }else{
            System.out.println("Minimum time to rot all oranges - " + result);
        }
    }
}

// Time complexity - O(m*n)