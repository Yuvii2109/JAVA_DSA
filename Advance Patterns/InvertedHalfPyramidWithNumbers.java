import java.util.Scanner;

public class InvertedHalfPyramidWithNumbers {
    public static void numPy(int n){
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of rows - ");
        int n = sc.nextInt();
        numPy(n);
        System.out.println();
        sc.close();
    }
}