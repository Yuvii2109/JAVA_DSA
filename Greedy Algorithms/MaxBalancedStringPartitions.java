// We have balanced string str of size N with an equal number of L and R, 
// the task is to find a maximum number X, such that a given string can be 
// partitioned into X balanced substring. A string is called to be balanced 
// if the number of ‘L’s in the string equals the number of ‘R’s.
// Input - “LRRRRLLRLLRL”
// Output - 3

import java.util.*;

public class MaxBalancedStringPartitions {
    public static int balancedSubstrings(String str) {
        StringBuilder s = new StringBuilder();
        int count = 0; // To track the balance between L and R
        int balancedCount = 0; // To count the number of balanced substrings

        // Iterate through each character in the string
        for (char ch : str.toCharArray()) {
            // Update count based on character
            if (ch == 'L') {
                s.append(ch);
                count++;
            } else if (ch == 'R') {
                s.append(ch);
                count--;
            }

            // If count becomes 0, a balanced substring is found
            if (count == 0) {
                System.out.println("Balanced Substring " + (balancedCount+1) + " - " + s);
                balancedCount++;
                s.setLength(0); // Reset the StringBuilder
            }
        }

        return balancedCount; // Return the total number of balanced substrings
    }
    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        System.out.println("Maximum number of balanced substrings - " + balancedSubstrings(str));
    }
}

// Time complexity - O(n)