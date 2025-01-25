// {1, 2, 3} and K = 3 => {1, 2}, {3} - 2 SubArrays

import java.util.HashMap;

public class SubArraySumEqualToK {
    public static int countSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        
        // Initialize the map with sum 0 to handle subarrays starting from index 0
        map.put(0, 1);
        
        for (int num : nums) {
            sum += num;
            
            // Check if (sum - k) is in the map
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            // Update the map with the current sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        
        int result = countSubarrays(nums, k);
        System.out.println("Number of subarrays with sum equal to " + k + " - " + result);
    }
}

// Time Complexity - O(n)