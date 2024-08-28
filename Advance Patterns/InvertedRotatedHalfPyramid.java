import java.util.Scanner;

public class InvertedRotatedHalfPyramid {
    public static void invRotHalfPy(int n){
        for(int i = 1; i <= n; i++){
            for(int j = n; j >= 1; j--){
                if(i >= 1 && i <= j-1){
                    System.out.print("  ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of rows - ");
        int n = sc.nextInt();
        invRotHalfPy(n);
        sc.close();
    }
}