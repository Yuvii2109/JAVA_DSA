// Node - At any moment, the number of down strokes cannot be more than the number of upstrokes.
// Upstroke => /, Down Stroke => \

public class MountainRanges {
    public static int mountainsAndValleys(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside * outside;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Number of ways to climb mountain with " + n + " pairs of upstrokes and down strokes - " + mountainsAndValleys(n));
    }
}