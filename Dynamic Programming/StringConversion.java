// Convert String1 to String2 with only insertion and deletion.
// Print the minimum number of operations required for the same.

public class StringConversion {
    public static void printDP(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int minOperations(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0) {
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insert = dp[i][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    dp[i][j] = Math.min(insert, delete);
                }
            }
        }
        System.out.println("DP Table - ");
        printDP(dp);
        return dp[n][m];
    }
    public static void main(String[] args) {
        String String1 = "pear";
        String String2 = "sea";
        System.out.println("Minimum number of operations required to convert String1 to String2 - " + minOperations(String1, String2));
    }
}