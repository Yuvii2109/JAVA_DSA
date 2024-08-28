import java.util.Scanner;

public class NumberPyramid {
    public static void numPy(int n){
        int num = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for(int k = 1; k <= i; k++){
                System.out.print(num + " ");
            }
            System.out.println();
            num++;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number - ");
        int n = sc.nextInt();
        numPy(n);
        System.out.println();
        sc.close();
    }
}