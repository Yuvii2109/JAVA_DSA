import java.util.Scanner;

public class Creation {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of rows - ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns - ");
        int columns = sc.nextInt();
        int[][] matrix = new int[rows][columns];

        // Input -
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.print("Enter the element at position [" + i + "][" + j + "] - ");
                matrix[i][j] = sc.nextInt();
            }
        }

        // Output -
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        sc.close();
    }
}