import java.util.*;

public class SquarePattern {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of stars in the side of the square - ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*     ");
            }
            System.out.println();
        }
        sc.close();
    }   
}