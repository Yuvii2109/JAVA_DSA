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
}