import java.util.*;

public class CallByValueSwap {
    public static void swap(float a, float b){
        float temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping: a = " + a + " b = " + b + "\n");
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a - ");
        float a = sc.nextFloat();
        System.out.print("Enter b - ");
        float b = sc.nextFloat();
        System.out.println("\nBefore swapping: a = " + a + " b = " + b);
        swap(a, b);
        sc.close();
    }
}