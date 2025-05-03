/*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue. We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively. You must solve this problem without using the library's sort function.

    Example 1 -
        Input - nums = [2,0,2,1,1,0]
        Output - [0,0,1,1,2,2]

    Example 2 -
        Input - nums = [2,0,1]
        Output - [0,1,2]
*/

public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;
        while(mid <= high){
            if(nums[mid] == 0){
                // If nums[mid] is 0, swap it with nums[low], and increment both low and mid. This moves 0 to the beginning part.
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                // If nums[mid] is 1, just increment mid. This leaves 1 in its place.
                mid++;
            }else{
                // If nums[mid] is 2, swap it with nums[high] and decrement high. This moves 2 to the end part.
                swap(nums, mid, high);
                high--;
            }
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}