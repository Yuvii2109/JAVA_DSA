import java.util.Scanner;

public class Searching {
    public static void searchElement(int[][] arr, int key){
        int row = arr.length;
        int col = arr[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] == key){
                    System.out.println("Element is present at index [" + i + "," + j + "]");
                }
            }
        }
    }
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
        System.out.print("\nEnter the element to be searched - ");
        int key = sc.nextInt();
        searchElement(matrix, key);
        System.out.println();
        sc.close();
    }
}