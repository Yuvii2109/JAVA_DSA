// Given an array of integers arr[ ]and an integer target, return 
// indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, 
// and you may not use the same element twice.
// You can return the answer in any order.
// Sample Input 1 - arr = [2, 7, 11, 15], target = 9
// Sample Output 1 - [0, 1]
// As arr[0] + arr[1] == 9, we return [0, 1].
// Sample Input 2 - arr = [3,2,4], target = 6
// Sample Output 2 - [1, 2]

import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store visited numbers and their indices
        HashMap<Integer, Integer> visited = new HashMap<>();
        
        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the difference needed to reach the target
            int difference = target - nums[i];
            // Difference is the number we need to find to get the target
            
            // Check if the HashMap contains the difference
            if (visited.containsKey(difference)) {
                // If found, return the indices of the current element and the difference
                return new int[]{visited.get(difference), i};
            }
            
            // Otherwise, store the current number and its index in the HashMap
            visited.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array (this shouldn't happen due to the problem constraints)
        return new int[]{};
    }

    public static void main(String[] args) {
        // Create an instance of the TwoSum class
        TwoSum twoSumSolver = new TwoSum();
        
        // Sample Input 1
        int[] arr1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSumSolver.twoSum(arr1, target1);
        System.out.println("Sample Input 1 Result - " + Arrays.toString(result1));
        
        // Sample Input 2
        int[] arr2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSumSolver.twoSum(arr2, target2);
        System.out.println("Sample Input 2 Result - " + Arrays.toString(result2));
        
        // Sample Input 3
        int[] arr3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSumSolver.twoSum(arr3, target3);
        System.out.println("Sample Input 3 Result - " + Arrays.toString(result3));
    }
}

/*
    First Test Case (arr1 and target1) -
        The twoSum method is called with arr1 = {2, 7, 11, 15} and target1 = 9.
        Inside twoSum -
        A HashMap<Integer, Integer> called visited is initialized.
        A for loop iterates over each element in the array -
        Iteration 1 (i = 0) -
            nums[0] = 2.
            difference = 9 - 2 = 7.
            visited does not contain 7, so 2 is added to visited with index 0 - visited = {2: 0}.
        Iteration 2 (i = 1) -
            nums[1] = 7.
            difference = 9 - 7 = 2.
            visited contains 2, meaning nums[1] and nums[0] form the solution.
            The indices [visited.get(2), 1] = [0, 1] are returned.
    The result [0, 1] is stored in result1.

    Second Test Case (arr2 and target2) -
        The twoSum method is called with arr2 = {3, 2, 4} and target2 = 6.
        Inside twoSum -
        visited is initialized as an empty HashMap.
        The for loop processes each element -
        Iteration 1 (i = 0) -
            nums[0] = 3.
            difference = 6 - 3 = 3.
            visited does not contain 3, so 3 is added: visited = {3: 0}.
        Iteration 2 (i = 1) -
            nums[1] = 2.
            difference = 6 - 2 = 4.
            visited does not contain 4, so 2 is added: visited = {3: 0, 2: 1}.
        Iteration 3 (i = 2) -
            nums[2] = 4.
            difference = 6 - 4 = 2.
            visited contains 2, so the indices [visited.get(2), 2] = [1, 2] are returned.
    The result [1, 2] is stored in result2.
        
    Third Test Case (arr3 and target3) -
        The twoSum method is called with arr3 = {3, 3} and target3 = 6.
        Inside twoSum -
        visited is initialized.
        The for loop processes -
        Iteration 1 (i = 0) -
            nums[0] = 3.
            difference = 6 - 3 = 3.
            visited does not contain 3, so 3 is added - visited = {3: 0}.
        Iteration 2 (i = 1) -
            nums[1] = 3.
            difference = 6 - 3 = 3.
            visited contains 3, so the indices [visited.get(3), 1] = [0, 1] are returned.
    The result [0, 1] is stored in result3.
*/