import java.util.Scanner;

public class TransposeMatrix {
    public static void transpose(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] transpose = new int[columns][rows];
        System.out.println("\nThe transposed matrix is - \n");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        for(int i = 0; i < columns; i++){
            for(int j = 0; j < rows; j++){
                System.out.print(transpose[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of rows in the matrix - ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns in the matrix - ");
        int columns = sc.nextInt();
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.print("Enter element [" + i + "][" + j + "] - ");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("\nOriginal Matrix - \n");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        transpose(matrix);
        System.out.println();
        sc.close();
    }
}