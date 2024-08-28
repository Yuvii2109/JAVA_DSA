import java.util.*;

public class Product {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number - ");
        float a = sc.nextFloat();
        System.out.print("Enter another number - ");
        float b = sc.nextFloat();
        System.out.println("Sum of two numbers is - " + (a*b));
        sc.close();
    }
}