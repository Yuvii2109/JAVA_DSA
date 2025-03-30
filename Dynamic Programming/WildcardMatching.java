/*
    Given an input string (s) and a pattern (p), implement wildcard 
    pattern matching with support for '?' and '*' where -
        '?' Matches any single character.
        '*' Matches any sequence of characters (including the empty sequence).
    The matching should cover the entire input string (not partial).

    Example 1 -
        Input - s = "aa", p = "a"
        Output - false
        Explanation - "a" does not match the entire string "aa".

    Example 2 -
        Input - s = "aa", p = "*"
        Output - true
        Explanation - '*' matches any sequence.

    Example 3 -
        Input - s = "cb", p = "?a"
        Output - false
        Explanation - '?' matches 'c', but the second letter is 'a', which does not match 'b'.
*/

public class WildcardMatching {
    public static boolean isMatch(String str, String pattern){
        int n = str.length();
        int m = pattern.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true; // Initialization

        // Handle cases where pattern is empty but str is not...
        for(int i = 1; i <= n; i++){
            dp[i][0] = false;
        }
        // Handle cases where str is empty but pattern might have leading '*'...
        for(int j = 1; j <= m; j++){
            if(pattern.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }else{
                dp[0][j] = false; // Vaise toh by default false hi rhega but just for the sake of being right let's do it...
            }
        }

        // Populating the DP Table -
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                // Case 1 - Agar Pattern ka jth char == '*' toh ya toh hum '*' ko str ke ith char ke barabar bana denga ya phir '*' ko ignore kardenge...
                if(pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                    // Case 2
                    dp[i][j] = dp[i-1][j-1]; // Last elements ko equal le liya
                }else{
                    dp[i][j] = false; // Case 3
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "baaabab";
        String p = "*a*a";
        String d = "*****ba*****ab";
        System.out.println(isMatch(s, p)); // false
        System.out.println(isMatch(s, d)); // true
    }
}