// Given a rod of n inches and an array of prices that includes prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces.
// length - {1, 2, 3, 4, 5, 6, 7, 8}
// price - {1, 5, 8, 9, 10, 17, 17, 20}
// rodLength - 8

public class RodCutting {
    public static void printDP(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int rodCutting(int length[], int price[], int totalRod){
        int n = price.length;
        int dp[][] = new int[n+1][totalRod+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=totalRod; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=totalRod; j++){
                if(length[i-1] <= j){
                    // Valid
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                }else{
                    // Invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println("DP Table - ");
        printDP(dp);
        return dp[n][totalRod];
    }
    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;
        System.out.println("Maximum obtainable value - " + rodCutting(length, price, rodLength));
    }
}