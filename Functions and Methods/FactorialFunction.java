import java.util.*;

public class FactorialFunction {
    public static int factorial(int a){
        int fact = 1;
        for(int i = a; i >= 1; i--){
            fact = fact*i;
        }
        return fact;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number you want to find the factorial of - ");
        int num = sc.nextInt();
        System.out.println("The factorial of " + num + " is " + factorial(num) + "\n");
        sc.close();
    }
}