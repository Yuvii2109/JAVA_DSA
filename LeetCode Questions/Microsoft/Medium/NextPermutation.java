/*
    A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

    For example, for arr = [1,2,3], the following are all the permutations of arr - [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
    The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

    For example, the next permutation of arr = [1,2,3] is [1,3,2].
    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
    Given an array of integers nums, find the next permutation of nums.

    The replacement must be in place and use only constant extra memory.

    Example 1 -
        Input - nums = [1,2,3]
        Output - [1,3,2]

    Example 2 -
        Input - nums = [3,2,1]
        Output - [1,2,3]

    Example 3 -
        Input - nums = [1,1,5]
        Output - [1,5,1]
*/

public class NextPermutation {
    // Dekho brute force ke hisaab se toh recursively har ek array ko generate karenge toh input nums ke baad generate ho rkhe array ko output krdenge which would account a time complexity of approx O(n!)
    // The goal is to modify the array in-place so that it becomes the next lexicographical permutation. If the current permutation is the highest, the method rearranges it to the lowest possible order (sorted in ascending order).
    public void nextPermutation(int[] nums) {
        int k = -1; 
        int n = nums.length;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                k = i; 
                break;
            }
        }
        // The index k identifies the pivot—the point where the sequence stops increasing from right to left. If no such index is found (k remains -1), it means the array is in descending order (i.e., the highest permutation).

        if(k == -1){
            reverse(nums, 0, n-1);
            return;
        }
        // When the array is in descending order, there is no next permutation (because it's already the highest). Reversing the array yields the smallest permutation, which is the required behavior when no lexicographically larger permutation exists.

        int largest = -1;
        for(int i = n-1; i > k; i--){
            if(nums[i] > nums[k]){
                largest = i;
                break;
            }
        }
        // This step locates the smallest number (from the right) that is larger than nums[k]. Swapping nums[k] with nums[l] guarantees that the new permutation will be just a bit larger than the original permutation.

        swap(nums, k , largest); // Swapping ensures that the pivot is replaced by the next larger element, moving us towards the next permutation in lexicographical order.
        reverse(nums, k+1, nums.length-1); // After the swap, the elements to the right of k remain in descending order. Reversing them places these elements in ascending order, ensuring that the overall permutation is the smallest lexicographical permutation greater than the original.
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int nums[], int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
        // Reversing ensures that the section of the array after the pivot is in the smallest possible order, which is necessary to obtain the next lexicographical permutation.
    }
}