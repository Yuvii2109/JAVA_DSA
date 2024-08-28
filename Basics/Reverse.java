import java.util.*;

public class Reverse {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number - ");
        int n = sc.nextInt();
        int rev = 0;
        while(n > 0){
            int digit = n%10;
            rev = rev*10 + digit;
            n = n/10;
        }
        System.out.println("Reverse of the number is - " + rev + "\n");
        sc.close();
    }
}