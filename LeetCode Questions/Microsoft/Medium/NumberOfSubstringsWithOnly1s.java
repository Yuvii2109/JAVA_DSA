/*
    Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 10^9 + 7.

    Example 1 -
        Input - s = "0110111"
        Output - 9
        Explanation - There are 9 substring in total with only 1's characters.
        "1" -> 5 times.
        "11" -> 3 times.
        "111" -> 1 time.

    Example 2 -
        Input - s = "101"
        Output - 2
        Explanation - Substring "1" is shown 2 times in s.

    Example 3 -
        Input - s = "111111"
        Output - 21
        Explanation - Each substring contains only 1's characters.
*/

public class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        long result = 0;
        long count = 0;
        int mod = 1_000_000_007;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++; // Incrementing count for consecutive '1'
            }else{
                // When a zero is encountered, add the substrings from the current group of 1's
                result = (result + count * (count + 1) / 2) % mod;
                count = 0; // Reset Count
            }
        }
        result = (result + count * (count + 1) / 2) % mod; // In case the last group ends with '1'
        return (int)result;
    }
}

// Mantra - Each group of consecutive 1's of length n produces 𝑛(𝑛+1)/2 substrings.