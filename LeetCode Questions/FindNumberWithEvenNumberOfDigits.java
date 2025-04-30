/*
    Given an array nums of integers, return how many of them contain an even number of digits. 

    Example 1 -
        Input - nums = [12,345,2,6,7896]
        Output - 2
        Explanation - 
            12 contains 2 digits (even number of digits). 
            345 contains 3 digits (odd number of digits). 
            2 contains 1 digit (odd number of digits). 
            6 contains 1 digit (odd number of digits). 
            7896 contains 4 digits (even number of digits). 
        Therefore only 12 and 7896 contain an even number of digits.

    Example 2 -
        Input - nums = [555,901,482,1771]
        Output - 1 
        Explanation - Only 1771 contains an even number of digits.
*/

public class FindNumberWithEvenNumberOfDigits {
    /*
        public int digitsIn(int n){
            int digits = 0;
            while(n != 0){
                digits++;
                n /= 10;
            }
            return digits;
        }
        public int findNumbers(int[] nums) {
            int count = 0;
            for(int num : nums){
                if(digitsIn(num)%2 == 0){
                    count++;
                }
            }
            return count;
        }
        public int findNumbers(int[] nums){
            int count = 0;
            for(int num : nums){
                if(String.valueOf(num).length() % 2 == 0){
                    count++;
                }
            }
            return count;
        }
        // Too Slow
    */
    public int findNumbers(int[] nums){
        int count = 0;
        for(int num : nums){
            if((num >= 10 && num < 100) || 
            (num >= 1000 && num < 10000) || 
            (num == 100000)){
                count++;
            }
        }
        return count;
    }
}