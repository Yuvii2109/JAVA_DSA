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