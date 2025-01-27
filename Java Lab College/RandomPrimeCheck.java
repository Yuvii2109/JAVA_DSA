import java.util.Random;

public class RandomPrimeCheck {
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
        Random random = new Random();
        int num = random.nextInt(101);
        System.out.println("Random number between 0 and 100: - " + num);
        if(isPrime(num)){
            System.out.println(num + " is a prime number");
        }else{
            System.out.println(num + " is not a prime number");
        }
    }
}