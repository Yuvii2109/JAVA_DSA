// Variation of Unbound Knapsack 

import java.util.Arrays;

public class CoinChange {
    public static void printDP(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int coinChange(int coins[], int sum){
        int n = coins.length;
        int dp[][] = new int[n+1][sum + 1];
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(coins[i - 1] <= j) {
                    // Valid
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; // Exclude + Include
                }else{
                    // Invalid
                    dp[i][j] = dp[i - 1][j]; // Exclude
                }
            }
        }
        System.out.println("DP Table - ");
        printDP(dp);
        return dp[n][sum];
        // Time Complexity - O(n*sum)
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        System.out.println("Number of ways to make sum " + sum + " using coins " + Arrays.toString(coins) + " is " + coinChange(coins, sum));
    }
}