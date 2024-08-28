import java.util.*;

public class Fever {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the temperature showing in the thermometer - ");
        float temp = sc.nextFloat();
        String check = (temp > 100) ? 
        "You've got fever bruh!\n" : "Changa hai tu vai\n";
        System.out.println(check);
        sc.close();
    }
}