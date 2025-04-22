/*
    Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order. 

    Example 1 -
        Input - nums = [1,2,3]
        Output - [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    Example 2 -
        Input - nums = [0,1]
        Output - [[0,1],[1,0]]

    Example 3 -
        Input - nums = [1]
        Output - [[1]]
*/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        backtrack(nums, used, current, result);
        return result;
    }
    public void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result){
        // If current permutation is as long as nums, we’ve chosen one element for each position → it’s complete.
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue; // Skip any number that’s already been used in this branch
            }
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, result);

            // Remove the last element and mark it unused
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}