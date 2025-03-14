// A subsequence of a string is a new string generated from an original string with some characters(can be none) deleted without changing the relative order of the remaining characters.
// (eg - "ace" is a subsequence of "abcde")
// Input - str1 = "abcde", str2 = "ace"
// Output - 3("ace")
// Input - str1 = "abcdge", str2 = "abedg"
// Output - 4("abdg")

public class LongestCommonSubsequence {
    public static int LCS(String str1, String str2, int n, int m){
        if(n == 0 || m == 0){
            return 0; // If there are no characters left in one string, then no common subsequence can exist beyond that point.
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return 1 + LCS(str1, str2, n-1, m-1); 
            // The code compares the last character of the current segment of str1 (str1.charAt(n-1)) with the last character of str2 (str2.charAt(m-1)). If they match, it means this character is part of the LCS. The function then adds 1 (for the matched character) and makes a recursive call to check the remaining characters in both strings (i.e., with indices n-1 and m-1).
        }else{
            int ans1 = LCS(str1, str2, n-1, m);
            int ans2 = LCS(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
            // If the characters do not match, the function explores two possibilities -
                // Option 1 - Remove the last character from str1 and keep str2 unchanged. This is computed as LCS(str1, str2, n-1, m).
                // Option 2 - Remove the last character from str2 and keep str1 unchanged. This is computed as LCS(str1, str2, n, m-1).
            // The function then returns the maximum value of these two possibilities, using Math.max(ans1, ans2).
        }
        // Time Complexity - O(2^(n+m))
    }
    public static int LCSMemoization(String str1, String str2, int n, int m, int dp[][]){
        if(n == 0 || m == 0){
            return 0; // If there are no characters left in one string, then no common subsequence
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = 1 + LCSMemoization(str1, str2, n-1, m-1, dp);
            return dp[n][m];
        }else{
            int ans1 = LCSMemoization(str1, str2, n-1, m, dp);
            int ans2 = LCSMemoization(str1, str2, n, m-1, dp);
            dp[n][m] = Math.max(ans1, ans2);
            return dp[n][m];
        }
        // Time Complexity - O(n*m)
    }
    public static void printDP(int dp[][]){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int LCSTabulation(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    // Option 1 (Exclude current character of str1) - By taking dp[i-1][j], we compute the LCS length for the substring of str1 excluding its current last character (str1[i-1]) while still considering the first j characters of str2.

                    // Option 2 (Exclude current character of str2) - By taking dp[i][j-1], we compute the LCS length for the substring of str2 excluding its current last character (str2[j-1]) while still considering the first i characters of str1.
                }
            }
        }
        System.out.println("DP Table - ");
        printDP(dp);
        return dp[n][m];
        // Time Complexity - O(n*m)
    }
    public static void main(String args[]){
        String str1 = "abcdge";
        String str2 = "abedg";
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < m+1; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(LCS(str1, str2, n, m));
        System.out.println(LCSMemoization(str1, str2, n, m, dp));
        System.out.println(LCSTabulation(str1, str2));
    }
}