// Rat in a Maze - You are given a starting position for a rat which is stuck 
// in a maze at an initial point (0, 0) (the maze can be thought of as a 2-dimensional
// plane). The maze would be given in the form of a square matrix of order N * N 
// where the cells with value 0 represent the maze’s blocked locations while value 1 
// is the open/available path that the rat can take to reach its destination.
// The rat's destination is at (N - 1, N - 1). Your task is to find all the 
// possible paths that the rat can take to reach from source to destination in the maze.
// The possible directions that it can take to move in the maze are 'U'(up) i.e. (x, y- 1), 
// 'D'(down) i.e. (x, y + 1) , 'L' (left) i.e. (x - 1, y), 'R' (right) i.e. (x + 1, y).

public class RatInAMaze {
    public static void printMaze(int sol[][]){
        // Prints the solution part in the matrix form indicating path by 1s
        for(int i = 0; i < sol.length; i++){
            for(int j = 0; j < sol.length; j++){
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int maze[][], int x, int y) {
        // if (x, y outside maze) return false
        // Ensures maze boundaries and avoids blockages
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }
    public static boolean solveMaze(int maze[][]){
        int n = maze.length;
        int sol[][] = new int[n][n];
        if(validMaze(maze, 0, 0, sol) == false){
            System.out.println("\nSolution doesn't exist");
            return false;
        }else{
            printMaze(sol);
            return true;
        }
    }
    public static boolean validMaze(int maze[][], int x, int y, int sol[][]){
        // This checks if the rat has reached the destination (bottom-right corner) 
        // of the maze. If the current cell (x, y) is the destination 
        // (x == maze.length - 1 and y == maze.length - 1) and is a valid path 
        // (maze[x][y] == 1), the cell is added to the solution (sol[x][y] = 1), 
        // and true is returned to indicate a successful path.
        if(x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1){
            sol[x][y] = 1;
            return true;
        }
        if(isSafe(maze, x, y) == true){
            // This checks if the current cell (x, y) is safe to move to. 
            // A cell is considered safe if:
            // It lies within the maze boundaries.
            // It is an open path (maze[x][y] == 1).
            if(sol[x][y] == 1){
                // If the current cell (x, y) is already marked as part of the 
                // solution (sol[x][y] == 1), return false. This prevents revisiting 
                // the same cell, which could lead to infinite recursion or cycles.
                return false;
            }
            sol[x][y] = 1; // The current cell (x, y) is marked as part 
            // of the solution by setting sol[x][y] = 1.
            if(validMaze(maze, x + 1, y, sol)){
                return true;
            }
            if(validMaze(maze, x, y+1, sol)){
                return true;
            }
            // The function attempts to move in two possible directions:
            // Downward: Calls validMaze(maze, x + 1, y, sol) to explore 
            // the next cell in the downward direction.
            // Rightward: Calls validMaze(maze, x, y + 1, sol) to explore 
            // the next cell in the rightward direction.
            // If either recursive call returns true, it means a solution 
            // exists, and the function returns true.
            sol[x][y] = 0; // Backtracking step
            return false;
            // If neither downward nor rightward paths lead to a solution, 
            // backtracking is performed:
            // The current cell (x, y) is unmarked (sol[x][y] = 0) to indicate 
            // it is not part of the solution. false is returned, signaling
            // that this path does not lead to the destination.
        }
        return false;
    }
    public static void main(String args[]){
        int maze[][] = { 
            { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 0 },
            { 1, 1, 1, 1 } 
        };
        solveMaze(maze);
    }
}

// Time Complexity: 𝑂(2^(𝑛^2)) in the worst case. !!Chee bhai!!