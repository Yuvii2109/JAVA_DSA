/*
    Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

    Example 1 -
        Input - pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        Output - true
        Explanation - We might do the following sequence:
        push(1), push(2), push(3), push(4),
        pop() -> 4,
        push(5),
        pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

    Example 2 -
        Input - pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
        Output - false
        Explanation - 1 cannot be popped before 2.
*/

import java.util.Stack;

public class ValidStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for(int num : pushed){
            stack.push(num); // Push current number to the stack
            // Check if we can pop elements from the stack
            while(!stack.isEmpty() && popIndex < popped.length && stack.peek() == popped[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        // If the stack is empty and we've processed all pops, return true
        return stack.isEmpty();
    }
}

/*
    pushed = [1, 2, 3, 4, 5]
    popped = [4, 5, 3, 2, 1]

    Initial State -
        stack = []
        popIndex = 0

    Step-by-step Execution -
        Push 1 -
            stack = [1]
            stack.peek() = 1 ≠ popped[0] = 4 → No pop

        Push 2 -
            stack = [1, 2]
            stack.peek() = 2 ≠ popped[0] = 4 → No pop

        Push 3 -
            stack = [1, 2, 3]
            stack.peek() = 3 ≠ popped[0] = 4 → No pop

        Push 4 -
            stack = [1, 2, 3, 4]
            stack.peek() = 4 == popped[0] → Pop
            stack = [1, 2, 3]
            popIndex = 1

        Push 5 -
            stack = [1, 2, 3, 5]
            stack.peek() = 5 == popped[1] → Pop
            stack = [1, 2, 3]
            popIndex = 2
            stack.peek() = 3 == popped[2] → Pop
            stack = [1, 2]
            popIndex = 3
            stack.peek() = 2 == popped[3] → Pop
            stack = [1]
            popIndex = 4
            stack.peek() = 1 == popped[4] → Pop
            stack = []
            popIndex = 5

        Final State -
            stack.isEmpty() → true
            popIndex == popped.length → true
*/