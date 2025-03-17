// A Substring is a contiguous sequence of characters within a string
// S1 = "ABCDE", S2 = "ABGCE" -> Output - 2 ("AB")
// S1 = "ABCDGH", S2 = "ACDGHR" -> Output - 4 ("CDGH")

public class LongestCommonSubstring {
    public static int LongestCommonSubstring(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String S1 = "ABCDGH";
        String S2 = "ACDGHR";
        System.out.println("Length of Longest Common Substring - " + LongestCommonSubstring(S1, S2));
    }
}