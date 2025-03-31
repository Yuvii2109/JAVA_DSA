/*
    Fibonacci Ka Bada Bhai... 
    C0 = 1, C1 = 1
    C2 = C0.C1 + C1.C0 = 1.1 + 1.1 = 1 + 1 = 2
    C3 = C0.C2 + C1.C1 + C2.C0 = 1.2 + 1.1 + 2.1 = 2 + 1 + 2 = 5
    Pattern - 
        0 -> n-1
        n-1 -> 0
        => For C4 - Sum of - 
        C0  C1  C2  C3
        x   x   x   x
        C3  C2  C1  C0
        => C4 = C0.C3 + C1.C2 + C2.C1 + C3.C0 = 1.5 + 1.2 + 2.1 + 5.1 
        => C4 = 5 + 2 + 2 + 5 = 14
*/

import java.util.Arrays;

public class CatalansNumber {
    public static int catalanRecursion(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += catalanRecursion(i) * catalanRecursion(n - i - 1);
        }
        return ans;
        // Time Complexity - O(4^n/Root(n))
    }
    public static int catalanMemoization(int n, int dp[]){
        if(n == 0 || n == 1){
            return dp[n] = 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += catalanMemoization(i, dp) * catalanMemoization(n - i - 1, dp);
        }
        return dp[n] = ans;
        // Time Complexity - O(n^2)
    }
    public static int catalanTabulation(int n){
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
        // Time Complexity - O(n^2)
    }
    public static void main(String args[]){
        int n = 4;
        System.out.println("Catalan number for n = " + n + " is " + catalanRecursion(n) + " - Recursive Approach");
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println("Catalan number for n = " + n + " is " + catalanMemoization(n, dp) + " - Memoization Appraoch");
        System.out.println("Catalan number for n = " + n + " is " +
        catalanTabulation(n) + " - Tabulation Approach");
    }
}