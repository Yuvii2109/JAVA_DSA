public class FirstAndLastOccurence {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        result[0] = findFirstOccurence(nums, target);
        result[1] = findLastOccurence(nums, target);
        return result;
    }
    public int findFirstOccurence(int nums[], int target){
        int index = -1, low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] >= target){
                high = mid-1;
            }else{
                low = mid+1;
            }
            if(nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }
    public int findLastOccurence(int nums[], int target){
        int index = -1, low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] <= target){
                low = mid+1;
            }else{
                high = mid-1;
            }
            if(nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }
}