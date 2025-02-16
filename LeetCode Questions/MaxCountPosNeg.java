public class MaxCountPosNeg{
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int firstNonNegative = binarySearch(nums, 0);
        int firstPositive = binarySearch(nums, 1);
        int negativeCount = firstNonNegative;
        int positiveCount = n-firstPositive;
        return Math.max(negativeCount, positiveCount);
    }
    public int binarySearch(int[] nums, int target){
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = (start + (end-start)/2);
            if(nums[mid] >= target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}