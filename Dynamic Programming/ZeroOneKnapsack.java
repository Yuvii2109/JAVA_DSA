// value[] = [15, 14, 10, 45, 30]
// weight[] = [2, 5, 1, 3, 4]
// Maximum weight = 7
// Find maximum profit

public class ZeroOneKnapsack {
    public static int knapsackBrute(int val[], int wt[], int W, int n){
        if(W == 0 || n == 0){
            return 0;
        }
        if(wt[n-1] <= W){
            // Valid
            int ans1 = val[n-1] + knapsackBrute(val, wt, W-wt[n-1], n-1); // Include
            int ans2 = knapsackBrute(val, wt, W, n-1); // Exclude
            return Math.max(ans1, ans2);
        }else{
            // Invalid
            return knapsackBrute(val, wt, W, n-1); // Exclude
        }
        // Time Complexity - O(2^n) - Recursive calls
    }
    public static int knapsackMemoization(int val[], int[] wt, int W, int n, int dp[][]){
        if(W == 0 || n == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1] <= W){
            // Valid
            int ans1 = val[n-1] + knapsackMemoization(val, wt, W-wt[n-1], n-1, dp); // Include
            int ans2 = knapsackMemoization(val, wt, W, n-1, dp); // Exclude
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }else{
            // Invalid
            dp[n][W] = knapsackMemoization(val, wt, W, n-1, dp); // Exclude
            return dp[n][W];
        }
        // Time Complexity - O(n*W)
    }
    public static int knapsackTabulation(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i = 0; i < n+1; i++){
            // 0th Col
            dp[i][0] = 0;
        }
        for(int i = 1; i < W+1; i++){
            // 0th Row
            dp[0][i] = 0;
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < W+1; j++){
                int value = val[i-1]; // ith item ki value
                int weight = wt[i-1]; // ith item ka weight
                if(weight <= j){ // Agar ith item ka weight is less than total allowed capacity
                    // Valid
                    int includeProfit = value + dp[i-1][j-weight]; // Include ith item
                    int excludeProfit = dp[i-1][j]; // Exclude ith item
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                }else{
                    // Invalid
                    dp[i][j] = dp[i-1][j]; // Exclude ith item
                }
            }
        }
        System.out.println("\nDP grid for tabulation - ");
        printDP(dp);
        return dp[n][W];
        // Time Complexity - O(n*W)
    }
    public static void printDP(int dp[][]){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int value[] = {15, 14, 10, 45, 30};
        int weight[] = {2, 5, 1, 3, 4};
        int W = 7;
        int n = value.length;
        int dp[][] = new int[n+1][W+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < W+1; j++){
                dp[i][j] = -1; // Initialization
            }
        }
        System.out.println("Maximum profit is (Brute Force Appraoch) - " + knapsackBrute(value, weight, W, n));
        System.out.println("Maximum profit is (Memoization Approach) - " + knapsackMemoization(value, weight, W, n, dp));
        System.out.println("Maximum profit is (Tabulation Approach) - " + knapsackTabulation(value, weight, W));
    }
}