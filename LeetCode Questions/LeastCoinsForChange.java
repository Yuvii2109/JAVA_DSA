import java.util.Arrays;

public class LeastCoinsForChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        int largeVal = amount+1;
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], largeVal); // Sabko highest value set krdo... 
        }
        // Base Case - When amount is 0, 0 coins are needed
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[n][amount] == largeVal){
            return -1;
        }else{
            return dp[n][amount];
        }
    }
}