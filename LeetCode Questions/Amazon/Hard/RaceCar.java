/*
    Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions. Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse) -

    When you get an instruction 'A', your car does the following -
        position += speed
        speed *= 2
    When you get an instruction 'R', your car does the following -
        If your speed is positive then speed = -1
        otherwise speed = 1
        Your position stays the same.
    For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3, and your speed goes to 1 --> 2 --> 4 --> -1.

    Given a target position target, return the length of the shortest sequence of instructions to get there.

    Example 1 -
        Input - target = 3
        Output - 2
        Explanation - 
        The shortest instruction sequence is "AA".
        Your position goes from 0 --> 1 --> 3.

    Example 2 -
        Input - target = 6
        Output - 5
        Explanation - 
        The shortest instruction sequence is "AAARA".
        Your position goes from 0 --> 1 --> 3 --> 7 --> 7 --> 6.
*/

public class RaceCar {
    public int racecar(int target) {
        // dp[i] will store the minimum instructions needed to reach position i
        int[] dp = new int[target+1];
        dp[0] = 0;
        // Filling the dp with large values 
        for(int i = 1; i <= target; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        // Computing all the positions from 1 to target - 
        for(int k = 1; k <= target; k++){
            // Find the smallest n such that the car overshoots or reaches target exactly - position after n 'A's is (2^n - 1).
            int n = 1; 
            while((1 << n) - 1 < k){
                // While (2^n - 1) is less than 1
                n++;
            }
            // If we hit the target directly then, the answer is n
            if((1 << n) - 1 == k){
                dp[k] = n;
            }else{
                // Case 1 - Overshoot and reverse. We overshoot by executing n 'A's and then one 'R'. The car overshoots to (2^n - 1) and we reverse direction. Then, we need to cover the extra distance (2^n - 1 - t).
                dp[k] = n + 1 + dp[(1 << n) - 1 - k];

                // Case 2 - Stop before reaching the target, reverse, and try again. Try every possible m where m in [0, n-1]. The car goes forward for n-1 accelerations and then reverses, and then goes backwards for m accelerations.
                for(int m = 0; m < n-1; m++){
                    // Distance covered after n-1 'A's is (2^(n-1) - 1) and then reversing and moving backward for m steps results in a position of - (2^(n-1) - 1) - (2^m - 1).
                    int position = (1 << (n-1)) - (1 << m);
                    dp[k] = Math.min(dp[k], (n - 1) + 1 + m + 1 + dp[k - position]);
                }
            }
        }
        return dp[target];
    }
}