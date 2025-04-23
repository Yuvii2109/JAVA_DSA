/*
    You are given an integer n. Each number from 1 to n is grouped according to the sum of its digits. Return the number of groups that have the largest size.  

    Example 1 -
        Input - n = 13
        Output - 4
        Explanation - There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
        [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
        There are 4 groups with largest size.

    Example 2 -
        Input - n = 2
        Output - 2
        Explanation - There are 2 groups [1], [2] of size 1.
*/

public class CountLargestGroup {
    public int countLargestGroup(int n) {
        // Since the maximum digit-sum for n up to, say, 10^5 is 9 * 5=45, we allocate a bit more room to be safe.
        // Any decimal digit is at most 9. If a number has D digits, the largest possible sum of its digits is 9+9+⋯+9(D times) = 9×D. So for n up to, say, 10^5 (which is a 6-digit number at most), the maximum digit-sum you’ll ever see is 9×6 = 54.
        int[] count = new int[50];
        for(int i = 1; i <= n; i++){
            int s = digitSum(i);
            count[s]++;
        }
        int maxSize = 0;
        for(int c : count){
            if(c > maxSize){
                maxSize = c;
            }
        }
        // Count how many groups have that size (excluding zero-sized)
        int result = 0;
        for (int c : count) {
            if (c == maxSize) {
                result++;
            }
        }
        return result;
    }
    private int digitSum(int x){
        int s = 0;
        while(x > 0){
            s += x%10;
            x /= 10;
        }
        return s;
    }
}