import java.util.*;

public class SumOfFirstN {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the last number of the series - ");
        int n = sc.nextInt();
        int sum = 0, count = 1;
        while (count <= n) {
            sum += count;
            count++;
        }
        System.out.println("Sum of first " + n + " natural numbers is - " + sum + "\n");
        sc.close();
    }
}