// Input a number from user and check if palindrome is possible by 
// shuffling digits of the number print yes or No as output.

import java.util.HashMap;
import java.util.Scanner;

public class PallindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number - ");
        String numberStr = sc.nextLine();
        
        // Convert the number to a character array for easier manipulation
        char[] digits = numberStr.toCharArray();
        
        // Count occurrences of each digit
        HashMap<Character, Integer> digitCount = new HashMap<>();
        for (char digit : digits) {
            digitCount.put(digit, digitCount.getOrDefault(digit, 0) + 1);
        }
        
        // Count how many digits have odd occurrences
        int oddCount = 0;
        for (int count : digitCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        
        // If more than one digit has odd occurrences, palindrome is not possible
        if (oddCount > 1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        
        sc.close();
    }
}