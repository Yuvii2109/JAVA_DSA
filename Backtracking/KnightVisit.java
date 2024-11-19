// Knight’s Tour - Given a N*N board with the Knight placed on the 
// first block of an empty board. Moving according to the rules of chess, 
// knights must visit each square exactly once. Print the order of
// each cell in which they are visited.

public class KnightVisit {
    static int n = 8; // The chessboard size is 8x8, so n = 8

    public static boolean isSafe(int x, int y, int sol[][]){
        return (x >= 0 && x < n && y >= 0 && y < n && sol[x][y] == -1);
    }
    // This method checks whether a knight can safely move to a position 
    // (x, y) on the chessboard. The conditions are:
    // The position (x, y) should be within the bounds of the board 
    // (0 <= x < n and 0 <= y < n).
    // The position (x, y) should not have been visited already 
    // (sol[x][y] == -1).
    // If these conditions are met, it returns true; otherwise, false.

    public static void printBoard(int sol[][]){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean knightTour(){
        int sol[][] = new int[n][n];
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                sol[x][y] = -1; // Initialize the board with -1 (unvisited)
            }
        }
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 }; // Horizontal moves
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 }; // Vertical moves
        // Sign convention ka dekh lio yaar khud se

        //As the Knight starts from cell(0,0)
        sol[0][0] = 0;

        if(!knightTourValidation(0, 0, 1, sol, xMove, yMove)){
            System.out.println("Solution does not exist");
            return false;
        }else{
            printBoard(sol);
        }
        return true;
    }
    // The method initializes the chessboard sol[][] with size n x n and 
    // fills it with -1 (indicating unvisited squares). It defines two arrays 
    // xMove[] and yMove[], which represent all possible moves of a knight from 
    // a given position. The knight can move in 8 possible directions:
    // Two squares in one direction and one square in a perpendicular direction, 
    // or vice versa. The knight starts at position (0, 0) and is assigned 
    // the value 0 on the board (sol[0][0] = 0). It calls the knightTourValidation 
    // method to try to find a valid tour starting from (0, 0). If the knight's 
    // tour is successful, it prints the board; otherwise, it prints "Solution does not exist".

    public static boolean knightTourValidation(int x, int y, int move, int sol[][], int xMove[], int yMove[]){
        // This method attempts to find a valid Knight's Tour using recursion.
        // It takes the current position (x, y) of the knight, the number 
        // of moves made so far (move), the chessboard (sol[][]), and the 
        // move arrays xMove[] and yMove[]. The base case is when the knight 
        // has visited all n * n squares (move == n * n). If so, it returns true, 
        // indicating the solution is found. The method tries all 8 possible moves 
        // of the knight by iterating over k (from 0 to 7).
        int k, next_x, next_y;
        if(move == n * n){
            return true;
        }
        for(k = 0; k < 8; k++){
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if(isSafe(next_x, next_y, sol)){
                // For each move, the method checks whether the knight can 
                // safely move to (next_x, next_y) using the isSafe method.
                // If it can, the position is marked as visited by setting 
                // sol[next_x][next_y] = move. Then, the method recursively 
                // calls itself to attempt to visit the next square. If the 
                // recursive call returns true, the tour is successful.
                // If the recursive call returns false (i.e., the tour can't 
                // continue from this position), the knight backtracks by 
                // setting sol[next_x][next_y] = -1, marking the square as 
                // unvisited.
                sol[next_x][next_y] = move;
                if(knightTourValidation(next_x, next_y, move + 1, sol, xMove, yMove)){
                    return true;
                }else{
                    sol[next_x][next_y] = -1; // Backtrack step
                }
            }
        }
        return false; // Default
    }


    public static void main(String args[]){
        knightTour();
    }
}