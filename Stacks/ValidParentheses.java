import java.util.*;

// Given a string containing just the characters '(',')','[',']','{' and '}', 
// determine if the input string is valid. An input string is valid if -
// i.) Open brackets must be closed by the same type of brackets.
// ii.) Open brackets must be closed in the correct order.
// iii.) Every close bracket has a corresponding open bracket of the same type.

public class ValidParentheses {
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                // Opening
                s.push(c);
            }else{
                // Closing
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && c == ')') || 
                (s.peek() == '[' && c == ']') ||
                (s.peek() == '{' && c == '}')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }

        // Agar empty ho chuka hai toh... valid hai varna invalid hai...
        return s.isEmpty(); 
    }
    public static void main(String[] args) {
        String str = "{({})[]}"; // Should give true
        if(isValid(str)){
            System.out.println("Valid use of parentheses");
        }else{
            System.out.println("Invalid use of parentheses");
        }
    }
}

// Linear Time Complexity - O(n)