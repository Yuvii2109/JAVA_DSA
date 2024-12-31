import java.util.*;

// A set of parentheses are duplicate if the same subexpression is 
// surrounded by the same type of parentheses multiple times. Example -
// (((a + (b)) + (c + d)) is a valid duplicate parentheses.
// ((a + b) + (c + d)) is an invalid duplicate parentheses.
// Seedhi bhaasha main bina baat ke khaam khaa parentheses lga dene ko
// duplicate parentheses kehte hain.

// CONDITION - The entered string is valid

public class DuplicateParentheses {
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {
                int count = 0;
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    count++;
                }
                // Pop the opening parenthesis '('
                if (!s.isEmpty()) {
                    s.pop();
                }
                // Check if there were redundant parentheses
                if (count < 1) {
                    return true;
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str1 = "(((a + (b))) + (c + d))"; // valid
        String str2 = "((a + b) + (c + d))"; // invalid
        if(isDuplicate(str1)){
            System.out.println(str1 + " - is a valid duplicate parentheses");
        }else{
            System.out.println(str1 + " - is not a valid duplicate parentheses");
        }
        if(isDuplicate(str2)){
            System.out.println(str2 + " - is a valid duplicate parentheses");
        }else{
            System.out.println(str2 + " - is not a valid duplicate parentheses");
        }
    }
}

// Linear Time Complexity - O(n)