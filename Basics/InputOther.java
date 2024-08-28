import java.util.*;

public class InputOther {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer - ");
        int i = sc.nextInt();
        System.out.println("You entered - " + i);

        System.out.print("Enter a float - ");
        float f = sc.nextFloat();
        System.out.println("You entered - " + f);
        sc.close();
    }
}