import java.util.*;

public class IncomeTax2024 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n2024 Income tax slab");
        System.out.print("Enter your annual income - ");
        float income = sc.nextFloat();
        if(income > 1500000){
            System.out.println("Your tax slab is 30%");
            float tax = income * 0.3f;
            System.out.println("Your tax is - " + tax + "\n");
        }else if(income > 1200000){
            System.out.println("Your tax slab is 20%");
            float tax = income * 0.2f;
            System.out.println("Your tax is - " + tax + "\n");
        }else if(income > 900000){
            System.out.println("Your tax slab is 15%");
            float tax = income * 0.15f;
            System.out.println("Your tax is - " + tax + "\n");
        }else if(income > 600000){
            System.out.println("Your tax slab is 10%");
            float tax = income * 0.1f;
            System.out.println("Your tax is - " + tax + "\n");
        }else if(income > 300000){
            System.out.println("Your tax slab is 5%");
            float tax = income * 0.05f;
            System.out.println("Your tax is - " + tax + "\n");
        }else{
            System.out.println("Tujhse bhi le liye toh tera kya hoga bhai?\n");
        }
        sc.close();
    }
}