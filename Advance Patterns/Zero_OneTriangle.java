import java.util.Scanner;

public class Zero_OneTriangle {
    public static void zeroOne(int n){
        int count = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                if(count%2 == 0){
                    System.out.print("0    ");
                }else{
                    System.out.print("1    ");
                }
                count++;
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of rows - ");
        int n = sc.nextInt();
        zeroOne(n);
        System.out.println();
        sc.close();
    }
}