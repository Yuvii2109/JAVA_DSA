/*
    You are given a 0-indexed integer array nums and two integers key and k. A k-distant index is an index i of nums for which there exists at least one index j such that |i - j| <= k and nums[j] == key.

    Return a list of all k-distant indices sorted in increasing order.

    Example 1 -
        Input - nums = [3,4,9,1,3,9,5], key = 9, k = 1
        Output - [1,2,3,4,5,6]
        Explanation - Here, nums[2] == key and nums[5] == key.
            - For index 0, |0 - 2| > k and |0 - 5| > k, so there is no j where |0 - j| <= k and nums[j] == key. Thus, 0 is not a k-distant index.
            - For index 1, |1 - 2| <= k and nums[2] == key, so 1 is a k-distant index.
            - For index 2, |2 - 2| <= k and nums[2] == key, so 2 is a k-distant index.
            - For index 3, |3 - 2| <= k and nums[2] == key, so 3 is a k-distant index.
            - For index 4, |4 - 5| <= k and nums[5] == key, so 4 is a k-distant index.
            - For index 5, |5 - 5| <= k and nums[5] == key, so 5 is a k-distant index.
            - For index 6, |6 - 5| <= k and nums[5] == key, so 6 is a k-distant index.
        Thus, we return [1,2,3,4,5,6] which is sorted in increasing order. 

    Example 2 -
        Input - nums = [2,2,2,2,2], key = 2, k = 2
        Output - [0,1,2,3,4]
        Explanation - For all indices i in nums, there exists some index j such that |i - j| <= k and nums[j] == key, so every index is a k-distant index. Hence, we return [0,1,2,3,4].
*/

import java.util.ArrayList;
import java.util.List;

public class FindAllKDistantIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        boolean[] isKDistant = new boolean[n];
        for(int j = 0; j < n; j++){
            if(nums[j] == key){
                // Computing the window boundaries
                int left = Math.max(0, j - k);
                int right = Math.min(n - 1, j + k);
                // Mark every index in [left, right]
                for(int i = left; i <= right; i++){
                    isKDistant[i] = true;
                }
            }
        }
        // Collect all the marked indices in sorted (increasing) order
        for(int i = 0; i < n; i++){
            if(isKDistant[i]){
                result.add(i);
            }
        }
        
        return result;
    }
}