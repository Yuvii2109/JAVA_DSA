import java.util.*;

public class Average3Num {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st number - ");
        float num1 = sc.nextFloat();
        System.out.print("Enter 2nd number - ");
        float num2 = sc.nextFloat();
        System.out.print("Enter 3rd number - ");
        float num3 = sc.nextFloat();
        float avg = (num1+num2+num3)/3;
        System.out.println("Average of the 3 entered numbers is - " + avg); 
        sc.close();
    }
}