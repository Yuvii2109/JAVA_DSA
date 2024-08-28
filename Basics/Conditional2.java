import java.util.*;

public class Conditional2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nThis program compares two numbers...");
        System.out.print("Enter the first number - ");
        float num1 = sc.nextFloat();
        System.out.print("Enter the second number - ");
        float num2 = sc.nextFloat();
        if(num1 < num2){
            System.out.println("The Second number is greater than the first number.\n");
        }else{
            System.out.println("The first number is greater than the second number.\n");
        }
        sc.close();
    }
}