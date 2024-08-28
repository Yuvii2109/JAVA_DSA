import java.util.Scanner;

public class PrimeFunctionOptimised {
    public static boolean isPrime(int n){
        boolean isPrime = false;
        if (n <= 1) {
            isPrime = false;
        }else if(n == 2){
            isPrime = true;
        }else if(n == 3){
            isPrime = true;
        }else{
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }else{
                    isPrime = true;
                }
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number - ");
        int n = sc.nextInt();
        if (isPrime(n)) {
            System.out.println(n + " is a prime number\n");
        }else{
            System.out.println(n + " is not a prime number\n");
        }
        sc.close();
    }
}