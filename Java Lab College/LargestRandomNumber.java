import java.util.Random;

public class LargestRandomNumber {
    public static void main(String[] args) {
        Random random = new Random();

        // Generate three random numbers between 0 and 100
        int num1 = random.nextInt(101); // 0 to 100 inclusive
        int num2 = random.nextInt(101);
        int num3 = random.nextInt(101);

        // Print the generated numbers
        System.out.println("Generated numbers - " + num1 + ", " + num2 + ", " + num3);

        // Find the largest number
        int largest = Math.max(num1, Math.max(num2, num3));

        // Print the largest number
        System.out.println("The largest number is - " + largest);
    }
}