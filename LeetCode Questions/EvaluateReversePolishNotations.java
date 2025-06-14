/*
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

    Evaluate the expression. Return an integer that represents the value of the expression.

    Note that -
        The valid operators are '+', '-', '*', and '/'.
        Each operand may be an integer or another expression.
        The division between two integers always truncates toward zero.
        There will not be any division by zero.
        The input represents a valid arithmetic expression in a reverse polish notation.
    The answer and all the intermediate calculations can be represented in a 32-bit integer.

    Example 1 -
        Input - tokens = ["2","1","+","3","*"]
        Output - 9
        Explanation - ((2 + 1) * 3) = 9

    Example 2 -
        Input - tokens = ["4","13","5","/","+"]
        Output - 6
        Explanation - (4 + (13 / 5)) = 6

    Example 3 -
        Input - tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        Output - 22
        Explanation - ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        = ((10 * (6 / (12 * -11))) + 17) + 5
        = ((10 * (6 / -132)) + 17) + 5
        = ((10 * 0) + 17) + 5
        = (0 + 17) + 5
        = 17 + 5
        = 22
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotations {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String t : tokens){
            switch(t){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    stack.push(dividend / divisor);
                    break;
                default: 
                    stack.push(Integer.parseInt(t));
                    break;
            }
        }
        return stack.pop();
    }
}