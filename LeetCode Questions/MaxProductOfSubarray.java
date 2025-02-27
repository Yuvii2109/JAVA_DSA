public class MaxProductOfSubarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            int current = nums[i];
            int tempMax = Math.max(current, Math.max(max_so_far * current, min_so_far * current));
            min_so_far = Math.min(current, Math.min(max_so_far * current, min_so_far * current));
            max_so_far = tempMax;
            result = Math.max(result, max_so_far);
        }
        return result;
    }
}