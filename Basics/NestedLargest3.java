import java.util.*;

public class NestedLargest3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nAaaoo gaaayessss Nastingggg krte hainnn...");
        System.out.print("Enter first number - ");
        float a = sc.nextFloat();
        System.out.print("Enter second number - ");
        float b = sc.nextFloat();
        System.out.print("Enter third number - ");
        float c = sc.nextFloat();
        if(a >= b){
            if(a >= c){
                System.out.println("Largest number is - " + a);
            }else if(c >= a){
                System.out.println("Largest number is - " + c);
            }
        }else if(b >= a ){
            if(b >= c){
                System.out.println("Largest number is - " + b);
            }else if(c >= b){
                System.out.println("Largest number is - " + c);
            }
        }else{
            System.out.println("Largest number is - " + c);
        }
        sc.close();
    }
}