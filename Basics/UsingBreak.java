import java.util.*;

public class UsingBreak {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nThis program inputs numbers until user enters 10...");
        while(true){
            System.out.print("Enter a number: ");
            float n = sc.nextFloat();
            if(n == 10.0f) {
                System.out.println();
                break;
            }
        }
        System.out.println("You entered a 10");
        System.out.println();
        sc.close();
    }
}