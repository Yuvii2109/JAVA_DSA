// Variation of 0-1 Knapsack

public class TargetSumSubset {
    public static void printDP(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean subsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        // i = items
        // j = target sum
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int value = arr[i-1];
                // Include -
                if(value <= j && dp[i-1][j-value] == true){
                    dp[i][j] = true;
                }else if(dp[i-1][j]){
                    // Exclude
                    dp[i][j] = true;
                }
            }
        }
        System.out.println("DP Table -");
        printDP(dp);
        return dp[n][target];
        // Time Complexity - O(n*target)
    }
    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;
        System.out.println(subsetSum(arr, sum));
    }
}