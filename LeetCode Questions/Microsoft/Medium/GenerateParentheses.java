/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    Example 1 -
        Input - n = 3
        Output - ["((()))","(()())","(())()","()(())","()()()"]

    Example 2 -
        Input - n = 1
        Output - ["()"]
*/

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Using backtracking, the initial string is empty, and using 0 opening and closing parentheses so far 
        backtrack(result, "", 0, 0, n);
        return result;
    }
    /**
     * The backtrack function builds valid parentheses strings by ensuring that -
     * 1. At any moment, the number of '(' is less than or equal to n.
     * 2. The number of ')' is less than the number of '(' at that point.
     * result - The list collecting all valid parentheses combinations
     * current - The current string being built
     * open - The count of '(' used so far
     * close - The count of ')' used so far
     * max - The total number of pairs of parentheses to generate.
     */
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // If the current String length is equal to 2 * max, it means we've used all the parentheses and the current configuration is valid.
        if(current.length() == (2 * max)){
            result.add(current);
            return;
        }
        // If we can still add an opening parenthesis, add it and recurse.
        if(open < max){
            backtrack(result, current + "(", (open+1), close, max);
        }
        // If we can add a closing parenthesis without breaking the well-formed rule, add it and recurse.
        if(close < open){
            backtrack(result, current + ")", open, (close+1), max);
        }
    }
}

/*
    For n = 3, backtrack(result, "", 0, 0, 3);
    This means -
        current is an empty string.
        open (number of "(") is 0.
        close (number of ")") is 0.
        max (total pairs) is 3.

    Level 0 (Initial Call) - 
        Call - backtrack(result, "", 0, 0, 3)
        Current - "" (length 0, not equal to 2×3=6)
        Decisions -
            Option 1 - Add "(" because open < max (0 < 3).
            Option 2 - Can't add ")" because close < open is false (0 is not less than 0).

    Level 1 - 
        Call - backtrack(result, "(", 1, 0, 3)
        Current - "(" (length 1)
        Decisions -
            Option 1 - Add "(" again because open < max (1 < 3).
            Option 2 - Add ")" is possible since close < open (0 < 1).

        Branch 1.1 (Adding another "(") - 
            Call - backtrack(result, "((", 2, 0, 3)
            Current - "((" (length 2)
            Decisions - 
                Option 1 - Add "(" because open < max (2 < 3). 
                Option 2 - Add ")" because close < open (0 < 2).

        Level 2 (Branch 1.1, Option 1 - Adding "(") - 
            Call - backtrack(result, "(((", 3, 0, 3) 
            Current - "(((" (length 3) 
            Decisions - 
                Option 1 - Cannot add "(" since open equals max (3 is not less than 3). 
                Option 2 - Add ")" since close < open (0 < 3).

        Branch 1.1.1 (Adding a ")") - 
            Call - backtrack(result, "((()", 3, 1, 3)
            Current - "((()" (length 4)
            Decisions -
                Option 1 - Cannot add "(" (open is already 3).
                Option 2 - Add ")" since close < open (1 < 3).

        Branch 1.1.1.1 (Adding a ")") - 
            Call - backtrack(result, "((())", 3, 2, 3)
            Current - "((())" (length 5)
            Decisions -
                Option 1 - Cannot add "(" (open equals 3).
                Option 2 - Add ")" since close < open (2 < 3).

        Branch 1.1.1.1.1 (Adding a ")") - 
            Call - backtrack(result, "((()))", 3, 3, 3)
            Current - "((()))" (length 6, equals 2×3)
            Action -
                The condition is met so "((()))" is added to result.
                Return to previous call.

        Backtracking to Level 2 (Branch 1.1, Option 2 - Adding ")") - 
            After finishing branch 1.1.1, go back up to the call with current = "((".
            State - backtrack(result, "((", 2, 0, 3)
            Already tried adding "(" above (branch 1.1).
            Now, Option 2 - Add a ")" because close < open (0 < 2).
            Call - backtrack(result, "(()", 2, 1, 3)

        Level 2 (Branch 1.2 - current = "(()") - 
            Call - backtrack(result, "(()", 2, 1, 3)
            Current - "(()" (length 3)
            Decisions -
                Option 1 - Add "(" because open < max (2 < 3).
                Option 2 - Add ")" because close < open (1 < 2).

        Branch 1.2.1 (Option 1: Add "(") - 
            Call - backtrack(result, "(()(", 3, 1, 3)
            Current - "(()(" (length 4)
            Decisions -
                Option 1 - Cannot add "(" (open equals 3).
                Option 2 - Add ")" because close < open (1 < 3).

        Branch 1.2.1.1 (Adding a ")") - 
            Call - backtrack(result, "(()()", 3, 2, 3) 
            Current - "(()()" (length 5) 
            Decisions - 
                Option 1 - Cannot add "(" (open equals 3). 
                Option 2 - Add ")" (since 2 < 3).

        Branch 1.2.1.1.1 (Adding a ")") -
            Call - backtrack(result, "(()())", 3, 3, 3) 
            Current - "(()())" (length 6) 
            Action -
                Reached the valid combination; add "(()())" to result. 
                Return.

        Branch 1.2.2 (Option 2: Add ")" from "(()") -
            After finishing the branch that started with "(()(", we backtrack to "(()" and now -
                Call - backtrack(result, "(())", 2, 2, 3) 
                Current - "(())" (length 4) 
                Decisions -
                    Option 1 - Add "(" because open < max (2 < 3). 
                    Option 2 - Add ")" is not allowed because close < open would be 2<2 which is false.

        Branch 1.2.2.1 (Adding "(") - 
            Call - backtrack(result, "(())(", 3, 2, 3)
            Current - "(())(" (length 5)
            Decisions -
                Option 1 - Cannot add "(" (open equals 3).
                Option 2 - Add ")" (because 2 < 3).

        Branch 1.2.2.1.1 (Adding a ")") - 
            Call - backtrack(result, "(())()", 3, 3, 3)
            Current - "(())()" (length 6)
            Action -
                Valid combination; add "(())()" to result.
                Return.

    Backtracking to Level 1 (Branch 2 - current = "(" Option 2 - Add ")" from Level 1)
    After all branches from current = "((" and "(()" have completed, we return to the call - 
        State - backtrack(result, "(", 1, 0, 3)
        We’ve explored the option of adding "(" from "(".
        Now, Option 2 - Since close < open (0 < 1), we add a ")".
        Call - backtrack(result, "()", 1, 1, 3)
        Current - "()" (length 2)
        Decisions -
            Option 1 - Add "(" because open < max (1 < 3).
            Option 2 - Add ")" is not allowed because close < open (1 is not less than 1).

    Branch 2.1 (From "()", Option 1: Add "(") - 
        Call - backtrack(result, "()(", 2, 1, 3)
        Current - "()(" (length 3)
        Decisions - 
            Option 1 - Add "(" because open < max (2 < 3).
            Option 2 - Add ")" since close < open (1 < 2).

    Branch 2.1.1 (Option 1 - Add "(") - 
        Call - backtrack(result, "()((", 3, 1, 3)
        Current - "()((" (length 4)
        Decisions -
            Option 1 - Cannot add "(" (open equals 3).
            Option 2 - Add ")" since close < open (1 < 3).

    Branch 2.1.1.1 (Adding a ")") - 
        Call - backtrack(result, "()(()", 3, 2, 3)
        Current - "()(()" (length 5)
        Decisions -
            Option 1 - Cannot add "(" (open equals 3).
            Option 2 - Add ")" (because 2 < 3).

    Branch 2.1.1.1.1 (Adding a ")") - 
        Call - backtrack(result, "()(())", 3, 3, 3)
        Current - "()(())" (length 6)
        Action - 
            Valid combination; add "()(())" to result.
            Return.

    Branch 2.1.2 (Option 2: From "()(" add ")") - 
    Go back to current = "()(" after finishing the branch with an extra "(".
        Call - backtrack(result, "()()", 2, 2, 3)
        Current - "()()" (length 4)
        Decisions -
            Option 1 - Add "(" since open < max (2 < 3).
            Option 2 - Adding ")" is not allowed immediately because close < open (2 is not less than 2).

    Branch 2.1.2.1 (Adding "(") - 
        Call - backtrack(result, "()()(", 3, 2, 3) 
        Current - "()()(" (length 5) 
        Decisions - 
            Option 1 - Cannot add "(" (open equals 3). 
            Option 2 - Add ")" since close < open (2 < 3).

    Branch 2.1.2.1.1 (Adding a ")") -
        Call - backtrack(result, "()()()", 3, 3, 3)
        Current - "()()()" (length 6)
        Action - 
            Valid combination; add "()()()" to result.
            Return.

Final Outcome - 
    After all recursive calls finish, the result list contains all valid combinations -
        "((()))" 
        "(()())" 
        "(())()" 
        "()(())" 
        "()()()" 
        These are the five valid combinations for n=3.
*/