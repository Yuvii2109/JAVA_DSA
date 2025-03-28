/*
    Given a binary string s, return the minimum number of character swaps 
    to make it alternating, or -1 if it is impossible. The string is 
    called alternating if no two adjacent characters are equal. For 
    example, the strings "010" and "1010" are alternating, while the 
    string "0100" is not. Any two characters may be swapped, even if they 
    are not adjacent.

    Example 1 -
        Input - s = "111000"
        Output - 1
        Explanation - Swap positions 1 and 4: "111000" -> "101010"
        The string is now alternating.

    Example 2 -
        Input - s = "010"
        Output - 0
        Explanation - The string is already alternating, no swaps are needed.

    Example 3 -
        Input - s = "1110"
        Output - -1
*/

public class MinimumNumberOfSwapsToMakeAStringAlternating {
    public int minSwaps(String s) {
        int count0 = 0, count1 = 0;
        int missing01 = 0, missing10 = 0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                count0++;
            }else{
                count1++;
            }
        }
        if(Math.abs(count0 - count1) > 1){
            return -1;
        }
        for(int i = 0; i < s.length(); i++){
            char expected1 = (i%2 == 0) ? '0' : '1'; // Expected character for "010101..."
            char expected2 = (i%2 == 0) ? '1' : '0'; // Expected character for "101010..."
            if(s.charAt(i) != expected1){
                missing01++; // Count mismatches for "010101..."
            }else if(s.charAt(i) != expected2){
                missing10++; // Count mismatches for "101010..."
            }
        }
        if(count0 == count1){
            return Math.min(missing01/2, missing10/2);
        }else if(count0 > count1){
            return missing01/2; // Only "010101..." pattern is possible
        }else{
            return missing10/2; // Only "101010..." pattern is possible
        }
    }
}