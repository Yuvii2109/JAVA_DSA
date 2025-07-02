/*
    Given an array of integers nums, calculate the pivot index of this array.

    The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

    If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

    Return the leftmost pivot index. If no such index exists, return -1.

    Example 1 -
        Input - nums = [1,7,3,6,5,6]
        Output - 3
        Explanation -
            The pivot index is 3.
            Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
            Right sum = nums[4] + nums[5] = 5 + 6 = 11

    Example 2 -
        Input - nums = [1,2,3]
        Output - -1
        Explanation - There is no index that satisfies the conditions in the problem statement.

    Example 3 -
        Input - nums = [2,1,-1]
        Output - 0
        Explanation -
            The pivot index is 0.
            Left sum = 0 (no elements to the left of index 0)
            Right sum = nums[1] + nums[2] = 1 + -1 = 0
*/

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int n = nums.length;   
        /*  
            if(n == 1){
                return nums[0];
            }
            int pre[] = new int[n];
            int post[] = new int[n];
            pre[0] = 0;
            post[n-1] = 0;
            for(int i = 1; i < n; i++){
                pre[i] = nums[i-1] + pre[i-1];
            }
            for(int j = n-2; j >= 0; j--){
                post[j] = nums[j+1] + post[j+1];
            }
            for(int k = 0; k < n; k++){
                if(pre[k] == post[k]){
                    return k;
                }
            }
        */
        for(int num : nums){
            total += num;
        }
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(leftSum == total - leftSum - nums[i]){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}