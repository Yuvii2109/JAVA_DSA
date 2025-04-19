/*
    Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s. 

    Example 1 -
        Input - s = "aab"
        Output - [["a","a","b"],["aa","b"]]

    Example 2 -
        Input - s = "a"
        Output - [["a"]]
*/

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result){
        // If we've consumed the entire string, add a copy of the path to the result
        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        // Try all the end positions for the next cut
        for(int end = start; end < s.length(); end++){
            // If s[start..end] is a palindrome, include it and recurse
            if(isPalindrome(s, start, end)){
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path, result);
                path.remove(path.size() - 1);  // backtrack
            }
        }
    }
    
    // Checks if s[left..right] is a palindrome in O(length) time
    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}

/*
    new PalindromePartitioning().partition("aab");
    We’ll track -
        the call to backtrack(s, start, path, result)
        the changes to path
        when a partition is added to result

    Initial call - backtrack("aab", start=0, path=[], result=[])
    First level (start = 0) - 
        Loop end from 0 to 2.
            a. end = 0 → substring s[0..0] = "a"
                isPalindrome("a") → true
                Add "a" to path - path = ["a"]
                backtrack("aab", start=1, path=["a"], result=[])

            b. end = 1 → substring s[0..1] = "aa"
                isPalindrome("aa") → true
                (We’ll come back to this after unwinding the first branch.)

            c. end = 2 → substring s[0..2] = "aab"
                isPalindrome("aab") → false, skip
                Second level (start = 1, path = ["a"])

        Loop end from 1 to 2.
            a. end = 1 → substring s[1..1] = "a"
                isPalindrome("a") → true
                Add "a" - path = ["a", "a"]
                backtrack("aab", start=2, path=["a","a"], result=[])

            b. end = 2 → substring s[1..2] = "ab"
                isPalindrome("ab") → false, skip
                Third level (start = 2, path = ["a","a"])

        Loop end = 2 only
        end = 2 → substring s[2..2] = "b"
        isPalindrome("b") → true
        Add "b" - path = ["a","a","b"]
        backtrack("aab", start=3, path=["a","a","b"], result=[])
        Base case (start = 3 == s.length())
        We’ve consumed the whole string. 
        Record a copy of path into result - result = [ ["a","a","b"] ]
        
        Then backtrack - remove last element - path reverts to ["a","a"]
        Unwind to second level (start=1) 
        No more end values. 
        Backtrack one more path reverts to ["a"]
        Back to first level (start=0), now try end = 1
        substring s[0..1] = "aa"
        isPalindrome("aa") → true

        Add "aa" - path = ["aa"]
        backtrack("aab", start=2, path=["aa"], result=[["a","a","b"]])
        Second branch, second level (start = 2, path = ["aa"])
        Only end = 2, s[2..2] = "b" → palindrome → add and recurse -
            path = ["aa","b"]
            backtrack("aab", start=3, path=["aa","b"], result=[["a","a","b"]])

    Base case again (start = 3) - 
    Add copy of ["aa","b"] to result - 
        result = [ ["a","a","b"], ["aa","b"] ]
        Backtrack removes "b", then removes "aa", and loops finish.

    Final result - [ ["a","a","b"], ["aa","b"] ]
*/