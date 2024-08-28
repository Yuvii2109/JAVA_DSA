import java.util.*;

public class Sum {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st number - ");
        float a = sc.nextFloat();
        System.out.print("Enter 2nd number - ");
        float b = sc.nextFloat();
        float sum = a + b;
        System.out.println("Sum of two numbers is - " + sum);
        sc.close();
    }
}