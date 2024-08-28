import java.util.*;

public class Ternary {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number - ");
        int a = sc.nextInt();
        String OddEve = ((a % 2) == 0) ? "Even Number" : "Odd Number";
        System.out.println(OddEve + "\n");
        sc.close();
    }
}