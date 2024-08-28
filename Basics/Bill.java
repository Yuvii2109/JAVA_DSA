import java.util.*;

public class Bill {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the price of item number 1 - ");
        float a = sc.nextFloat();
        System.out.print("Enter the price of item number 2 - ");
        float b = sc.nextFloat();
        System.out.print("Enter the price of item number 3 - ");
        float c = sc.nextFloat();
        double total = (a+b+c)*(1.18);
        System.out.println("The total bill is - " + total + "\n");
        sc.close();
    }
}