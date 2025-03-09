public class ScoreOfAllPrefixesOfAnArray {
    public long[] findPrefixScore(int[] nums) {
        // [2] - arr[0] + max till arr[0] + score = 2+2+0 = 4
        // [2, 3] - arr[1] + max till arr[1] + score = 3+3+4 = 10
        // [2, 3, 7] - arr[2] + max till arr[2] + score = 7+7+10 = 24...
        long arr[] = new long[nums.length];
        int max = nums[0];
        arr[0] = (long) nums[0] + max;
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            arr[i] = nums[i] + max + arr[i-1];
        }
        return arr;
    }
}