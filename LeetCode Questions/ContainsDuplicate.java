// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct. 
// Example 1 - Input - nums = [1,2,3,1]
// Output - true
// Explanation - The element 1 occurs at the indices 0 and 3.
// Example 2 - Input - nums = [1,2,3,4]
// Output - false
// Explanation - All elements are distinct.
// Example 3 - Input - nums = [1,1,1,3,3,4,3,2,4,2]
// Output - true

public class ContainsDuplicate {
    /*
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            boolean result = false;
            for(int i = 0; i < nums.length; i++){
                for(int j = nums.length-1; j > i; j--){
                    if(nums[i] == nums[j] && Math.abs(i-j) == k){
                        result = true;
                    }
                }            
            }
            return result;
        }
    */
    // Let's optimize it using HashSet and sliding window
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]); // Removes the element just outside the valid window of k size
            }
        }
        return false;
    }
}