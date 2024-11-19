import java.util.Scanner;

public class NQueensOneSol {
    static int count = 0;
    public static boolean nQueens(char board[][], int row){
        if(row == board.length){
            count++;
            return true;
        }
        // Column loop
        for(int j = 0; j < board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if(nQueens(board, row+1)){
                    return true;
                }
                board[row][j] = '-'; // Backtracking step
            }
        }
        return false;
    }
    public static boolean isSafe(char board[][], int row, int column){
        // Checking for vertically upwards
        for(int i = row-1; i >= 0; i--){
            if(board[i][column] == 'Q'){
                return false;
            }
        }

        // Checking for diagonally leftwards
        for(int i = row-1, j = column-1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false; 
            }
        }

        // Checking for diagonally righwards
        for(int i = row-1, j = column+1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // Else -
        return true;
    }
    public static void printBoard(char board[][]){
        System.out.println("\n-----------CHESS BOARD------------");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of boxes on the chess board - ");
        int n = sc.nextInt();
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '-';
            }
        }
        if(nQueens(board, 0)){
            System.out.println("\nSolution is possible - ");
            printBoard(board);
            System.out.println();
        }else{
            System.out.println("\nSolution is not possible - ");
        }
    }
}