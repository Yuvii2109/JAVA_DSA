import java.util.*;

public class ForFactorial {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number you wish to find factorial of - ");
        int n = sc.nextInt();
        int fact = 1;
        for(int i = n; i >= 1; i--){
            fact = fact * i;
        }
        System.out.println("Factorial of " + n + " is " + fact + "\n");
        sc.close();
    }
}