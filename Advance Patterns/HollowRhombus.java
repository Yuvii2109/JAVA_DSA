import java.util.Scanner;

public class HollowRhombus {
    public static void hollowRhombus(int n){
        for(int i = n; i >= 1; i--){
            for(int j = i-1; j >= 1; j--){
                System.out.print("  ");
            }
            for(int k = 1; k <= n; k++){
                if(k == 1 || k == n || i == 1 || i == n){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the unit length of the side of the rhombus - ");
        int n = sc.nextInt();
        hollowRhombus(n);
        System.out.println();
        sc.close();
    }
}