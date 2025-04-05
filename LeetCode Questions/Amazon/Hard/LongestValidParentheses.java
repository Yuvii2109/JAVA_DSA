/*
    Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring. 

    Example 1 - 
        Input - s = "(()"
        Output - 2
        Explanation - The longest valid parentheses substring is "()".

    Example 2 - 
        Input - s = ")()())"
        Output - 4
        Explanation - The longest valid parentheses substring is "()()".

    Example 3 - 
        Input - s = ""
        Output - 0
*/

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // Stack to store indices 
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for length calculation
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                // Push the index of '('
                stack.push(i);
            }else{
                // Pop the last '(' index 
                stack.pop();
                if(stack.isEmpty()){
                    // No matching '(', push current index as new base
                    stack.push(i);
                }else{
                    // Found a valid pair, calculate length - 
                    int length = i - stack.peek();
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }
}

/*
    Input - ")()())"
    Initial Setup -
        stack = [-1] → helps calculate lengths and handles edge cases
        maxLength = 0

    Loop through the string -
        i = 0, char = ) - 
            stack.pop() → removes -1
            stack is now empty, so we push current index 0
            stack = [0]
            No valid substring yet

        i = 1, char = ( - 
            Push index - stack.push(1)
            stack = [0, 1]
            Still no valid substring

        i = 2, char = ) -
            stack.pop() → removes 1
            stack = [0]
            Now stack is not empty → valid substring from stack.peek() = 0
            length = i - stack.peek() = 2 - 0 = 2
            maxLength = max(0, 2) = 2
            Valid substring - "()"

        i = 3, char = ( -
            Push index - stack.push(3)
            stack = [0, 3]
            Stack updated

        i = 4, char = ) - 
            stack.pop() → removes 3
            stack = [0]
            length = 4 - 0 = 4
            maxLength = max(2, 4) = 4
            Valid substring - "()()"

        i = 5, char = ) - 
            stack.pop() → removes 0
            stack = []
            Stack is empty → push current index 5
            stack = [5]
            No valid substring at this point

    Final Answer - maxLength = 4
*/