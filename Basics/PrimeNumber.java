import java.util.*;

public class PrimeNumber {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nThis program checks if a number is prime...");
        System.out.print("Enter a number - ");
        int n = sc.nextInt();

        if(n == 1){
            System.out.println(n + " is neither prime nor composite\n");
        }else if(n == 2 || n == 3){
            System.out.println(n + " is a prime number\n");
        }else{
            boolean isPrime = true;
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(n + " is a prime number\n");
            }else{
                System.out.println(n + " is not a prime number\n");
            }
        }
        sc.close();
    }
}