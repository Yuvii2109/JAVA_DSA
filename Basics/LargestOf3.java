import java.util.*;

public class LargestOf3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the first number: ");
        float a = sc.nextFloat();
        System.out.print("Enter the second number: ");
        float b = sc.nextFloat();
        System.out.print("Enter the third number: ");
        float c = sc.nextFloat();
        if(a > b && a > c){
            System.out.println("Largest number is: "+ a + "\n");
        }else if(b > a && b > c){
            System.out.println("Largest number is: " + b + "\n");
        }else{
            System.out.println("Largest number is: " + c + "\n");
        }
        sc.close();
    }
}