/*
    You are given an integer array nums. You are initially positioned at 
    the array's first index, and each element in the array represents your 
    maximum jump length at that position. Return true if you can reach the 
    last index, or false otherwise. 

    Example 1 -
    Input - nums = [2,3,1,1,4]
    Output - true
    Explanation - Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2 -
    Input - nums = [3,2,1,0,4]
    Output - false
    Explanation - You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
*/

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // To track the farthest index we can reach
        for(int i = 0; i < nums.length; i++){
            if(i > maxReach){
                // If current index is beyond maxReach
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]); // Updating maxReach with the farthest point reachable from current index
            if(maxReach >= nums.length-1){
                // If we reach the last index
                return true;
            }
        }
        return false; // If loop completes without reaching last index, return false
    }
}