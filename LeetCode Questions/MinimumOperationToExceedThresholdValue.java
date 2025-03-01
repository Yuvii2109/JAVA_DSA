public class MinimumOperationToExceedThresholdValue{
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] < k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}

// Linear search se better time complexity aayegi but mujhe binary perform krne ka man tha bas