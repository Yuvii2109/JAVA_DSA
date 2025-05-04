/*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one. You must implement a solution with a linear runtime complexity and use only constant extra space. 

    Example 1 -
        Input - nums = [2,2,1]
        Output - 1

    Example 2 -
        Input - nums = [4,1,2,1,2]
        Output - 4

    Example 3 - 
        Input - nums = [1] 
        Output - 1
*/

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        // XOR-ing all numbers together - duplicates cancel out, leaving the single one
        for(int num : nums){
            result ^= num;
        }
        return result;
    }
}