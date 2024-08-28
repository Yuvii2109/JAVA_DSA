import java.util.Scanner;

public class AverageOf3Function {
    public static void Avg(float a, float b, float c){
        float average = (a + b + c) / 3;
        System.out.println("\nThe average of " + a + ", " + b + ", " +c + " is " + average + "\n");
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the first number - ");
        float a = sc.nextFloat();
        System.out.print("Enter the second number - ");
        float b = sc.nextFloat();
        System.out.print("Enter the third number - ");
        float c = sc.nextFloat();
        Avg(a, b, c);
        sc.close();
    }
}