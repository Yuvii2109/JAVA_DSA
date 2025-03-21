/*
    Given two strings word1 and word2, return the minimum number of 
    operations required to convert word1 to word2. You have the following three operations permitted on a word - 
    - Insert a character
    - Delete a character
    - Replace a character
    
    Example 1 -
        Input - word1 = "horse", word2 = "ros"
        Output - 3
        Explanation - 
        horse -> rorse (replace 'h' with 'r')
        rorse -> rose (remove 'r')
        rose -> ros (remove 'e')

    Example 2 -
        Input - word1 = "intention", word2 = "execution"
        Output - 5
        Explanation - 
        intention -> inention (remove 't')
        inention -> enention (replace 'i' with 'e')
        enention -> exention (replace 'n' with 'x')
        exention -> exection (replace 'n' with 'c')
        exection -> execution (insert 'u')
*/

public class EditDistance {
    public static void printDP(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int minSteps(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    // Last Character same - Jitna choti wali problem ko solve hone main steps lagenge utne hi steps badi wali problem ko solve hone main lagenge
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    // Last Character different - 3 options - Insert, Delete, Replace
                    int insert = dp[i][j-1] + 1; // Last letter same banane ke liye same letter doosre string main add kardia
                    int delete = dp[i-1][j] + 1; // Last letter same banane ke liye ek string se aakhri letter delete krdia 
                    int replace = dp[i-1][j-1] + 1; // Last letter same banane ke liye ek string ka letter replace krdia 
                    dp[i][j] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }
        System.out.println("DP Table - ");
        printDP(dp);
        return dp[n][m];
        // Time Complexity - O(n*m)
    }
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println("Minimum number of operations required to convert str1 to str2 - " + minSteps(word1, word2));
    }
}