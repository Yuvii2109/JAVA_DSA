/*
    You are given two integer arrays nums1 and nums2, sorted in 
    non-decreasing order, and two integers m and n, representing the 
    number of elements in nums1 and nums2 respectively. Merge nums1 and 
    nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but 
    instead be stored inside the array nums1. To accommodate this, nums1 
    has a length of m + n, where the first m elements denote the elements 
    that should be merged, and the last n elements are set to 0 and should 
    be ignored. nums2 has a length of n.

    Example 1 -
        Input - nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output - [1,2,2,3,5,6]
        Explanation - The arrays we are merging are [1,2,3] and [2,5,6].
        The result of the merge is [1,2,2,3,5,6] with the underlined 
        elements coming from nums1.

    Example 2 -
        Input - nums1 = [1], m = 1, nums2 = [], n = 0
        Output - [1]
        Explanation - The arrays we are merging are [1] and [].
        The result of the merge is [1].

    Example 3 -
        Input - nums1 = [0], m = 0, nums2 = [1], n = 1
        Output - [1]
        Explanation - The arrays we are merging are [] and [1].
        The result of the merge is [1].
        Note that because m = 0, there are no elements in nums1. The 0 is 
        only there to ensure the merge result can fit in nums1.
*/

public class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int primaryPointer = m+n-1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[primaryPointer] = nums1[i];
                i--;
            }else{
                nums1[primaryPointer] = nums2[j];
                j--;
            }
            primaryPointer--;
        }
        while(j >= 0){
            nums1[primaryPointer] = nums2[j];
            j--;
            primaryPointer--;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        MergeTwoSortedArrays obj = new MergeTwoSortedArrays();
        obj.merge(nums1, m, nums2, n);
        for(int i = 0; i < nums1.length; i++){
            System.out.print(nums1[i] + " ");
        }
    }
}

/*
    Initialization -
        nums1 = {1, 2, 3, 0, 0, 0}, m = 3
        nums2 = {2, 5, 6}, n = 3
        Pointers - i = 2 (last valid element in nums1), j = 2 (last in 
        nums2), primaryPointer = 5 (last in nums1).

    Merging process (from the end) -
        Compare nums1[2] (3) and nums2[2] (6), place 6 at nums1[5], 
        decrement j and primaryPointer.
        Compare nums1[2] (3) and nums2[1] (5), place 5 at nums1[4], 
        decrement j and primaryPointer.
        Compare nums1[2] (3) and nums2[0] (2), place 3 at nums1[3], 
        decrement i and primaryPointer.
        Compare nums1[1] (2) and nums2[0] (2), place 2 at nums1[2], 
        decrement j and primaryPointer.

    Remaining elements in nums2 -
        nums2 is empty, so no further action is needed.
        Final nums1 - {1, 2, 2, 3, 5, 6}

    Printing output -
        Prints -> 1 2 2 3 5 6
*/