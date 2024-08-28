import java.util.*;

public class ParameterFunction {
    public static void calculateSum(float x, float y){
        float c = x + y;
        System.out.println("\nThe sum of these numbers is - " + c + "\n");
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the first number - ");
        float a = sc.nextFloat();
        System.out.print("Enter the second number - ");
        float b = sc.nextFloat();
        calculateSum(a,b);
        sc.close();
    }
}