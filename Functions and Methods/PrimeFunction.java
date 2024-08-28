import java.util.Scanner;

public class PrimeFunction {
    public static boolean isPrime(int n){
        boolean isPrime = true;
        for(int i = 2; i <= n-1; i++){
            if(n % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a number - ");
        int n = sc.nextInt();
        if(isPrime(n)){
            System.out.println(n + " is a prime number\n");
        }else{
            System.out.println(n + " is not a prime number\n");
        }
        sc.close();
    }
}