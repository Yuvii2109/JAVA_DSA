// We have an encoded string s and the task is to decode it. 
// The pattern in which the strings are encoded is as follows.
// Sample Input 1 : 2[cv]
// Sample Output 1 : cvcv
// Sample Input 2 : 3[b2[v]]L
// Sample Output 2 : bvvbvvbvv

import java.util.Stack;

public class DecodeAString {
    static String decode(String str){

        Stack<Integer> integerstack = new Stack<>();
        Stack<Character> stringstack = new Stack<>();
        // integerstack: To store numbers (multipliers for substrings).
        // stringstack: To store characters of the encoded string.

        String temp = "", result = "";
        for (int i = 0; i < str.length(); i++){
            int count = 0;

            // If the current character is a digit:
            // Initialize count to 0 to compute the number.
            if (Character.isDigit(str.charAt(i))){
                while (Character.isDigit(str.charAt(i))){
                    // The loop continues as long as the current character
                    // (str.charAt(i)) is a digit.
                    // Character.isDigit(char) is a utility method that 
                    // returns true if the character is a numeric digit (0-9).

                    count = count * 10 + str.charAt(i) - '0';
                    // This line computes the number represented by 
                    // consecutive digits in the string. Here's how:
                    // str.charAt(i): Retrieves the current character 
                    // (a digit as a character, e.g., '5').
                    // str.charAt(i) - '0': Converts the character to 
                    // its numeric value.
                    // ASCII value of '0' is 48.
                    // ASCII value of '5' is 53.
                    // Subtracting '0' from '5' gives 53 - 48 = 5.
                    // count * 10: Shifts the current value of count one 
                    // place to the left in the decimal system (equivalent 
                    // to adding a new digit).
                    // Adding the digit: The digit is added to count.
                    // Example -
                    // Suppose count = 0 initially, and the input is "12[a]".
                    // First iteration (i = 0, str.charAt(i) = '1'):
                    // count = 0 * 10 + ('1' - '0') = 1.
                    // Second iteration (i = 1, str.charAt(i) = '2'):
                    // count = 1 * 10 + ('2' - '0') = 12.

                    i++; // Advances the index i to the next character in the 
                    // string to continue checking for additional digits.
                }
                i--;
                // After the loop ends, i points to the character just after 
                // the last digit. i-- moves the index back by one so that 
                // the main for loop doesn't skip a character when it increments 
                // i at the next iteration.
                // Why is this adjustment needed?
                // The for loop will automatically increment i after this block. 
                // Without i--, the next character after the digits would be skipped.
                // For example:
                // Input: "12[a]".
                // After processing digits, i = 2 points to '['.
                // i-- ensures i = 1 before the for loop increments it to 2 again.

                integerstack.push(count);
            }else if (str.charAt(i) == ']'){
                // When encountering a closing bracket (]), it means a 
                // substring has ended, and decoding begins.
                temp = "";
                count = 0;
                if (!integerstack.isEmpty()){
                    count = integerstack.peek();
                    integerstack.pop();
                }
                while (!stringstack.isEmpty() && stringstack.peek()!='[' ){
                    temp = stringstack.peek() + temp;
                    // Concatenates the character at the top of the stack 
                    // to the start of the temp string.
                    // Why prepend (+ temp) instead of append (temp +)?
                    // Characters are stored in the stack in reverse order 
                    // of how they were encountered in the input string.
                    // Prepending ensures temp is constructed in the 
                    // correct order.
                    stringstack.pop();
                }
                if (!stringstack.empty() && stringstack.peek() == '['){
                    stringstack.pop();
                }
                for (int j = 0; j < count; j++){
                    result += temp;
                }
                for (int j = 0; j < result.length(); j++){
                    stringstack.push(result.charAt(j));
                    // Pushes the characters obtained in the result into the
                    // stringstack.
                }
                result = ""; // Resets the result for the next segment.
            }else if (str.charAt(i) == '['){
                if (Character.isDigit(str.charAt(i-1))){
                    stringstack.push(str.charAt(i));
                }else{
                    stringstack.push(str.charAt(i));
                    integerstack.push(1);
                }
            }else{
                stringstack.push(str.charAt(i));
            }
        }
        while (!stringstack.isEmpty()){
            result = stringstack.peek() + result;
            stringstack.pop();
        }
        return result;    
    }
    public static void main(String[] args) {
        System.out.println(decode("3[a]2[bc]"));
    }
}