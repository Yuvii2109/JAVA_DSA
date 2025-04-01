/*
    Given a string s, return the longest palindromic substring in s.

    Example 1 -
        Input - s = "babad"
        Output - "bab"
        Explanation - "aba" is also a valid answer.

    Example 2 -
        Input - s = "cbbd"
        Output - "bb"
*/

public class LongestPalindromicSubString {
    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            // Expand around a single center (odd-length palindromes)
            int len1 = expandAroundCenter(s, i, i);
            // Expand around two centers (even-length palindromes)
            int len2 = expandAroundCenter(s, i, i+1);
            int maxLength = Math.max(len1, len2); // Taking the max length from the obtained palindromes
            // Updating the start and end pointers if a longer palindrome is found
            if(maxLength > (end-start)){
                start = i - (maxLength-1)/2;
                end = i + maxLength/2;
            }
        }
        return s.substring(start, end+1);
    }
    private static int expandAroundCenter(String s, int left, int right){
        // Expand while the characters on both sides match and are within bounds
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; // Move left to left 
            right++; // Move right to right
        }
        // The length of the palindrome is (right - left - 1) because loop exits after overshooting
        return right-left-1;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}

/*
    Input -
        s = "babad"

    Step 1 - Initialization
        start = 0
        end = 0

    Step 2 - Loop Iteration Over i
        Iteration 1 - i = 0 (Character 'b')
            Expand Around Center (Odd-Length) - 
                expandAroundCenter(s, 0, 0) → "b"
                Expands and stops (len1 = 1).
            Expand Around Center (Even-Length) - 
                expandAroundCenter(s, 0, 1) → ""
                Characters s[0] ≠ s[1], so len2 = 0.
            Max Length & Update - 
                maxLength = max(1, 0) = 1
                start = 0 - (1 - 1) / 2 = 0
                end = 0 + 1 / 2 = 0

        Iteration 2 - i = 1 (Character 'a')
            Expand Around Center (Odd-Length) - 
                expandAroundCenter(s, 1, 1) → "bab"
                Expands from "a" to "bab" (len1 = 3).
            Expand Around Center (Even-Length) -
                expandAroundCenter(s, 1, 2) → ""
                s[1] ≠ s[2], so len2 = 0.
            Max Length & Update -
                maxLength = max(3, 0) = 3
                start = 1 - (3 - 1) / 2 = 0
                end = 1 + 3 / 2 = 2

        Iteration 3 - i = 2 (Character 'b')
            Expand Around Center (Odd-Length) -
                expandAroundCenter(s, 2, 2) → "aba"
                Expands from "b" to "aba" (len1 = 3).
            Expand Around Center (Even-Length) -
                expandAroundCenter(s, 2, 3) → ""
                s[2] ≠ s[3], so len2 = 0.
            Max Length & Update -
                maxLength = max(3, 0) = 3
                start = 2 - (3 - 1) / 2 = 1
                end = 2 + 3 / 2 = 3

        Iteration 4 - i = 3 (Character 'a') 
            Expand Around Center (Odd-Length) - 
                expandAroundCenter(s, 3, 3) → "a"
                Expands from "a" to "a" (len1 = 1).
            Expand Around Center (Even-Length) - 
                expandAroundCenter(s, 3, 4) → ""
                s[3] ≠ s[4], so len2 = 0.
            Max Length & Update - 
                maxLength = max(1, 0) = 1
                No update needed since maxLength < end - start.

        Iteration 5 - i = 4 (Character 'd')
            Expand Around Center (Odd-Length) - 
                expandAroundCenter(s, 4, 4) → "d"
                Expands from "d" to "d" (len1 = 1).
            Expand Around Center (Even-Length) - 
                expandAroundCenter(s, 4, 5) → ""
                Out of bounds, so len2 = 0.
            Max Length & Update - 
                maxLength = max(1, 0) = 1
                No update needed since maxLength < end - start.

        Final Calculation - 
            Substring Extraction - 
                s.substring(start, end + 1) = s.substring(1, 4) = "aba"
            Final Output - 
                "aba"  (or "bab", as both are valid palindromic substrings)
*/