import java.util.*;

public class PrimeTillNumberN {
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
    public static void primeInRange(int n){
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");
    }
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number till which you want to find out the prime numbers - ");
        int n = sc.nextInt();
        primeInRange(n);
        sc.close();
    }
}