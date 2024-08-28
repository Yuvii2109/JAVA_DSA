import java.util.Scanner;

public class FloydsTriangle {
    public static void Floyd(int n){
        int count = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of rows - ");
        int n = sc.nextInt();
        Floyd(n);
        System.out.println();
        sc.close();
    }
}