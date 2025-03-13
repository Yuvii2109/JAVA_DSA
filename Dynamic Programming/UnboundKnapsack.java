public class UnboundKnapsack {
    public static void printDP(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int unboundKnapsack(int[] val, int wt[], int W){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i-1] <= j) {
                    // Valid
                    // Same article can be chosen again...
                    dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]); // Max of include and exclude
                }else{
                    // Not valid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println("DP Table - ");
        printDP(dp);
        return dp[n][W];
        // Time complexity - O(n*W)
    }
    public static void main(String args[]){
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println("Maximum value we can get is - " + unboundKnapsack(val, wt, W));
    }
}