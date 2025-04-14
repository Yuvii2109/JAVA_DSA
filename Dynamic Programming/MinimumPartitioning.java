// Ek given array ko 2 sets main partition karna hai in a way ki unn do sets ke elements ke sum ko liya jaaye and unka difference kiya jaaye toh difference minimize ho rha ho...
// Example - numbers[] = {1, 6, 11, 5}
// Output - minDifference = 1

public class MinimumPartitioning {
    public static int minDifference(int[] numbers) {
        int n = numbers.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
        }
        int w = sum/2;
        int[][] dp = new int[n+1][w+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                /*
                    Iss initialization  ki zaroort nahi hai cuz we are coding in java...
                    if (i == 0) {
                        dp[i][j] = 0;
                    }
                    if (j == 0) {
                        dp[i][j] = 0;
                    }
                */
                if (numbers[i-1] <= j) {
                    // Valid - 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-numbers[i-1]] + numbers[i-1]); // Exclude + Include
                }else{
                    // Invalid -
                    dp[i][j] = dp[i-1][j]; // Isme exclude hi karte hain
                }
            }
        }
        System.out.println("DP Table so formed - ");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        int sum1 = dp[n][w];
        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }
    public static void main(String[] args) {
        int[] numbers = {1, 6, 11, 5};
        System.out.println("Minimum Difference between the partitioned subsets - " + minDifference(numbers));
    }
}