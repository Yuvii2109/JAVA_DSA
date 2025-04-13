import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int MCM(int[] arr, int i, int j){
        if(i == j){
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int cost1 = MCM(arr, i, k);
            int cost2 = MCM(arr, k+1, j);
            int cost3 = arr[i-1]*arr[k]*arr[j]; 
            // cost1 is the cost of multiplying the first i to k matrices
            // cost2 is the cost of multiplying the k+1 to j matrices
            // cost3 is the cost of multiplying the i to k and k+1 to j matrices
            int finalCost = cost1 + cost2 + cost3;
            minCost = Math.min(minCost, finalCost);
        }
        return minCost;
    }
    public static int MCMMemoization(int arr[], int i, int j, int[][] dp){
        if(i == j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int minCost = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int cost1 = MCMMemoization(arr, i, k, dp);
            int cost2 = MCMMemoization(arr, k+1, j, dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1 + cost2 + cost3;
            minCost = Math.min(minCost, finalCost);
        }
        dp[i][j] = minCost;
        return minCost;
    }
    // Ise toh ignore hi karde bhai...
    public static int MCMTabulation(int arr[]){
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 0;
        }
        for(int length = 2; length < n; length++){
            for(int i = 1; i < n - length + 1; i++){
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                }
            }
        }
        System.out.println("DP Table so formed - ");
        printDP(dp);
        return dp[1][n-1];
    }
    public static void printDP(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        System.out.println("Minimum cost of scalar multiplications is (Brute Force)- " + MCM(arr, 1, n-1));
        int dp[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Minimum cost of scalar multiplications is (Memoization)- " + MCMMemoization(arr, 1, n-1, dp));
        System.out.println("Minimum cost of scalar multiplications is (Tabulation)- " + MCMTabulation(arr));
    }
}

/*
    A = 1 x 2
    B = 2 x 3
    C = 3 x 4
    D = 4 x 3
    A x B = 1 x 3 => Cost = 1 x 2 x 3 = 6
    (A x B) x C = 1 x 4 => Cost = 1 x 3 x 4 = 12
    ((A x B) x C) x D = 1 x 3 => Cost = 1 x 4 x 3 = 12
    Total Cost = 6 + 12 + 12 = 30
*/