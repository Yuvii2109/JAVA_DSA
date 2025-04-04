/*
    Given two sorted arrays nums1 and nums2 of size m and n respectively, 
    return the median of the two sorted arrays. The overall run time 
    complexity should be O(log (m+n)). 

    Example 1 -
        Input - nums1 = [1,3], nums2 = [2]
        Output - 2.00000
        Explanation - merged array = [1,2,3] and median is 2.

    Example 2 -
        Input - nums1 = [1,2], nums2 = [3,4]
        Output - 2.50000
        Explanation - merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
*/

public class MedianOfTwoSortedArrays {
    // We need to find the median of two sorted arrays without merging them, and we must do it in O(log(m+n)) time. This means we can’t simply combine and sort the arrays.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // To minimize the binary search space, we always perform the binary search on the smaller array. If nums1 is larger than nums2, we swap them. This makes our binary search efficient since it will operate on the array with fewer elements.
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        int halfLength = (m+n+1)/2;
        // Imagine splitting both arrays into two parts such that all elements on the left side of the split (from both arrays) are less than or equal to all elements on the right side. Let -
        // partitionX be the split index for nums1. partitionY be the split index for nums2, computed as halfLen − partitionX, where halfLen is half of the total length of the two arrays (plus one to handle odd total lengths).
        while(left <= right){
            int partitionX = (left + right)/2;
            int partitionY = halfLength - partitionX;
            // Handle edge cases for partitions -
            // If partitionX is 0, it means nothing is on the left side, so we use Integer.MIN_VALUE. If partitionX equals the length of nums1, nothing is on the right side, so we use Integer.MAX_VALUE.
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            // Similar handling for nums2.
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

             // Check if we have found the correct partitions.
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // If the total number of elements is even.
                if ((m + n) % 2 == 0) {
                    return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    // If the total number of elements is odd, return the max of the left elements.
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // We are too far to the right in nums1, so move left.
                right = partitionX - 1;
            } else {
                // We are too far to the left in nums1, so move right.
                left = partitionX + 1;
            }
        }
        
        // If the input arrays are not valid (which should not occur), throw an exception.
        throw new IllegalArgumentException("Input arrays are not sorted or of invalid size.");
    }
}