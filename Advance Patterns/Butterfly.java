import java.util.Scanner;

public class Butterfly {
    public static void butterfly(int n){
        for(int i = 1; i <= n; i++){
            // stars - i
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            // spaces - 2*(n-i)
            for(int k = 1; k <= 2*(n-i); k++){
                System.out.print("  ");
            }
            // stars - i
            for(int l = 1; l <= i; l++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i = n; i >= 1; i--){
            // stars - i
            for(int j = i; j >= 1; j--){
                System.out.print("* ");
            }
            // spaces - 2*(n-i)
            for(int k = 1; k <= 2*(n-i); k++){
                System.out.print("  ");
            }
            // stars - i
            for(int l = i; l >= 1; l--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the length of half of the butterfly - ");
        int n = sc.nextInt();
        butterfly(n);
        System.out.println();
        sc.close();
    }
}