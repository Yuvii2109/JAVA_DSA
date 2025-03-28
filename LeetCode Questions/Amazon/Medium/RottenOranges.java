/*
    You are given an m x n grid where each cell can have one of three values -
        0 representing an empty cell,
        1 representing a fresh orange, or
        2 representing a rotten orange.

    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

    Example 1 -
    Input - grid = [[2,1,1],[1,1,0],[0,1,1]]
    Output - 4

    Example 2 -
    Input - grid = [[2,1,1],[0,1,1],[1,0,1]]
    Output - -1
    Explanation - The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

    Example 3 -
    Input - grid = [[0,2]]
    Output - 0
    Explanation - Since there are already no fresh oranges at minute 0, the answer is just 0.
*/

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count_fresh = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j, 0}); // {x, y, minutes}
                }
                if(grid[i][j] == 1){
                    count_fresh++;
                }
            }
        }
        if(count_fresh == 0) return 0; // No fresh oranges to begin with
        int countMin = 0, count = 0, minutes = 0;
        int directionX[] = {0, 0, -1, 1}; // Change in column index (Right, Left)
        int directionY[] = {1, -1, 0, 0}; // Change in row index (Up, Down)

        // Performing BFS to rot neighbouring oranges
        while(!q.isEmpty()){
            int current[] = q.poll();
            int x = current[0];
            int y = current[1];
            minutes = current[2];
            for(int k = 0; k < 4; k++){ // 4 possible directions
                int nx = x + directionX[k];
                int ny = y + directionY[k];
                if(nx >= 0 && nx < rows && ny >= 0 && ny < columns && grid[nx][ny] == 1){
                    grid[nx][ny] = 2; // Rot it
                    q.offer(new int[]{nx, ny, minutes+1});
                    count_fresh--;
                }
            }
        }
        return count_fresh == 0 ? minutes : -1;
    }
}

/*
    Queue (q) stores all initially rotten oranges (grid[i][j] == 2).
    Count fresh oranges (count_fresh).
    Row - 0, Column - 0, Value - 2 => Add(0, 0, 0) to q
    Row - 0, Column - 1, Value - 1 => count_fresh++ (1)
    Row - 0, Column - 2, Value - 1 => count_fresh++ (2)
    Row - 1, Column - 0, Value - 1 => count_fresh++ (3)
    Row - 1, Column - 1, Value - 1 => count_fresh++ (4)
    Row - 1, Column - 2, Value - 0 => No Action
    Row - 2, Column - 0, Value - 0 => No Action
    Row - 2, Column - 1, Value - 1 => count_fresh++ (5)
    Row - 2, Column - 2, Value - 1 => count_fresh++ (6)

    q = [(0,0,0)] (Only one rotten orange at (0,0))
    count_fresh = 6
    minutes = 0

    Minute 1 (Processing (0,0))
    q.poll() → (0,0,0)
    Possible directions to check - 
    Right (0,1) → grid[0][1] = 1, rot it → grid[0][1] = 2, q.offer((0,1,1))
    Left (not possible)
    Up (not possible)
    Down (1,0) → grid[1][0] = 1, rot it → grid[1][0] = 2, q.offer((1,0,1))
    count_fresh = 4
    Queue - q = [(0,1,1), (1,0,1)]

    Minute 2 (Processing (0,1))
    q.poll() → (0,1,1)
    Possible directions -
    Right (0,2) → grid[0][2] = 1, rot it → grid[0][2] = 2, q.offer((0,2,2))
    Left (0,0) (Already rotten, skip)
    Down (1,1) → grid[1][1] = 1, rot it → grid[1][1] = 2, q.offer((1,1,2))
    count_fresh = 2
    Queue - q = [(1,0,1), (0,2,2), (1,1,2)]

    Minute 3 (Processing (1,0))
    q.poll() → (1,0,1)
    Possible directions
    Right (1,1) (Already rotten, skip)
    Down (2,0) (Not an orange, skip)
    Queue - q = [(0,2,2), (1,1,2)]

    Minute 4 (Processing (0,2))
    q.poll() → (0,2,2)
    Possible directions
    Down (1,2) (Not an orange, skip)
    Queue - q = [(1,1,2)]

    Minute 5 (Processing (1,1))
    q.poll() → (1,1,2)
    Possible directions
    Down (2,1) → grid[2][1] = 1, rot it → grid[2][1] = 2, q.offer((2,1,3))
    count_fresh = 1
    Queue - q = [(2,1,3)]

    Minute 6 (Processing (2,1))
    q.poll() → (2,1,3)
    Possible directions -
    Right (2,2) → grid[2][2] = 1, rot it → grid[2][2] = 2, q.offer((2,2,4))
    count_fresh = 0
    Queue - q = [(2,2,4)]

    Minute 7 (Processing (2,2))
    q.poll() → (2,2,4)
    No fresh oranges left.

    Step 3 - Check Final Condition
    Since count_fresh == 0, we return minutes = 4.
    Final Answer - 4 minutes for all oranges to rot.

    Final Grid State - 
        grid = [[2,2,2],
                [2,2,0],
                [0,2,2]]
    All fresh oranges have rotted successfully.
*/