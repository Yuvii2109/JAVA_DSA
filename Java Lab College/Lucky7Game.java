import java.util.Random;
import java.util.Scanner;

public class Lucky7Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain;
        do {
            // Roll two dice
            int die1 = random.nextInt(7); // Dice roll between 1 and 6
            int die2 = random.nextInt(7);
            int sum = die1 + die2;

            System.out.println("You rolled - " + die1 + " and " + die2);
            System.out.println("Total - " + sum);

            // Check if the sum is 7
            if (sum == 7) {
                System.out.println("Congratulations! You got a Lucky 7! You win!");
            } else {
                System.out.println("Better luck next time");
            }

            // Ask the player if they want to play again
            System.out.print("Do you want to play again? (yes/no) - ");
            playAgain = scanner.nextLine().trim().toLowerCase();
        } while (playAgain.equals("yes"));

        System.out.println("Thanks for playing the Lucky 7 Game! Goodbye!");
        scanner.close();
    }
}