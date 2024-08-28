import java.util.Scanner;

public class SumOfDigits {
    public static void sumOfDigits(int n) {
        int sum = 0;
        int num = n;
        while(n>0){
            int rem = n%10;
            sum  += rem;
            n /= 10;
        }
        System.out.print("The sum of digits of the number - " + num + " is - " + sum);
        System.out.println("\n");
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number - ");
        int n = sc.nextInt();
        sumOfDigits(n);
        sc.close();
    }
}