/*
    Given an integer array nums sorted in non-decreasing order, remove 
    the duplicates in-place such that each unique element appears only 
    once. The relative order of the elements should be kept the same. 
    Then return the number of unique elements in nums.

    Consider the number of unique elements of nums to be k, to get 
    accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain
    the unique elements in the order they were present in nums initially. 
    The remaining elements of nums are not important as well as the size 
    of nums.

    Return k.

    Example 1 -
    Input - nums = [1,1,2]
    Output - 2, nums = [1,2,_]
    Explanation - Your function should return k = 2, with the first two 
    elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they 
    are underscores).

    Example 2 -
    Input - nums = [0,0,1,1,1,2,2,3,3,4]
    Output - 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation - Your function should return k = 5, with the first five 
    elements of nums being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they 
    are underscores).
*/

public class RemoveDuplicatesFromSortedArray {
    public static int mergeSortedArray(int[] nums){
        int k = 1;
        for(int y = 1; y < nums.length; y++){
            if(nums[y] != nums[y - 1]){
                nums[k] = nums[y];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 2, 2, 3};
        int k = mergeSortedArray(nums);
        System.out.println(k);
    }
}

/*
    Dry Run - 

    Initial state - nums = {0, 1, 1, 1, 2, 2, 3} and k = 1.
    Iteration -
        y = 1 - nums[1] = 1, nums[0] = 0. Not equal, so nums[1] is copied to nums[1], k becomes 2.
        y = 2 - nums[2] = 1, nums[1] = 1. Equal, so skip copying.
        y = 3 - nums[3] = 1, nums[2] = 1. Equal, skip.
        y = 4 - nums[4] = 2, nums[3] = 1. Not equal, so nums[4] is copied to nums[2], k becomes 3.
        y = 5 - nums[5] = 2, nums[4] = 2. Equal, skip.
        y = 6 - nums[6] = 3, nums[5] = 2. Not equal, so nums[6] is copied to nums[3], k becomes 4.
    After the loop - nums = {0, 1, 2, 3, 2, 2, 3} and k = 4.
    Output - 4 (number of unique elements).
*/