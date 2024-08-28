import java.util.*;

public class Calculator {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nThis program is a switch powered calculator...");
        System.out.print("Enter the first number - ");
        float a = sc.nextFloat();
        System.out.print("Enter the second number - ");
        float b = sc.nextFloat();
        System.out.println("Select any of the given options (1-5) - ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
        System.out.print("\nEnter your choice of operation - ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("\nThe result is - " + (a + b) + "\n");
                break;
            case 2:
                System.out.println("\nThe result is - " + (a - b) + "\n");
                break;
            case 3: 
                System.out.println("\nThe result is - " + (a * b) + "\n");
                break;
            case 4:
                if (b != 0) {
                    System.out.println("\nThe result is - " + (a / b) + "\n");
                }else{
                    System.out.println("\nError! Division by zero is not allowed\n");
                }
                break;
            case 5:
                break;
            default: 
                System.out.println("\nInvalid choice\n");
        }
        sc.close();
    }   
}