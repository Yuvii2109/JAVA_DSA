import java.util.Scanner;

public class GridWaysOptimized {
    public static int fact(int num){
        if(num == 0){
            return 1;
        }else{
            return num * fact(num-1);
        }
    }
    public static int gridWays(int n, int m){
        return fact(n+m-2)/(fact(n-1)*fact(m-1));
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of columns - ");
        int n = sc.nextInt();
        System.out.print("Enter the number of rows - ");
        int m = sc.nextInt();
        System.out.println("\nNumber of ways - " + gridWays(n,m) + "\n");
    }
}