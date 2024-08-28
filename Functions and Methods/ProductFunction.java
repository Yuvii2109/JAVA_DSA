import java.util.*;

public class ProductFunction {
    public static float multiply(float a, float b){
        float prod = a*b;
        return prod;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the first number - ");
        float a = sc.nextFloat();
        System.out.print("Enter the second number - ");
        float b = sc.nextFloat();
        System.out.println("Product of the two numbers is - " + multiply(a,b) + "\n");
        sc.close();
    }
}