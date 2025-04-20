/*
    Given a string s, find the longest palindromic subsequence's length in s. A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

    Example 1 -
        Input - s = "bbbab"
        Output - 4
        Explanation - One possible longest palindromic subsequence is "bbbb".

    Example 2 -
        Input - s = "cbbd"
        Output - 2
        Explanation - One possible longest palindromic subsequence is "bb".
*/

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();

        // dp[i][j] = length of the longest palindromic subsequence in s[i..j]
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 1; // A single character is a palindrome of length 1 (Starting and ending at i)
        }

        // Filling in reverse row order - 
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    // If the two characters match, they can “wrap” around whatever the LPS is in between
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    // Otherwise, the best is either skipping the left char or skipping the right char
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // The answer for the whole string is dp[0][n-1]
        return dp[0][n - 1];
    }
}