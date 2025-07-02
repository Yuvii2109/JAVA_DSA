/*
    Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

    A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true -
        0 <= i, j < nums.length
        i != j
        |nums[i] - nums[j]| == k
        Notice that |val| denotes the absolute value of val.

    Example 1 -
        Input - nums = [3,1,4,1,5], k = 2
        Output - 2
        Explanation - There are two 2-diff pairs in the array, (1, 3) and (3, 5). Although we have two 1s in the input, we should only return the number of unique pairs.

    Example 2 -
        Input - nums = [1,2,3,4,5], k = 1
        Output - 4
        Explanation - There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

    Example 3 -
        Input - nums = [1,3,1,5,4], k = 0
        Output - 1
        Explanation - There is one 0-diff pair in the array, (1, 1).
*/

import java.util.HashMap;
import java.util.Map;

public class KDifferentPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        // Build frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        if(k == 0){
            // Case k = 0 - we're looking for numbers that appear at least twice
            for(int occurrences : freq.values()){
                if(occurrences > 1){
                    count++;
                }
            }
        }else{
            // Case k > 0 - for each distinct num, check if num + k exists
            for(int num : freq.keySet()){
                if(freq.containsKey(num + k)){
                    count++;
                }
            }
        }
        return count;
    }
}