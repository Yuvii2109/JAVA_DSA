// Divide and Conquer Method -> Time complexity - O(nlogn)

// Idea : If we know the majority element in the left and right halves of an array, we can
// determine which is the global majority element in linear time. Here, we
// apply a classical divide & conquer approach that recurses on the left and right
// halves of an array until an answer can be trivially achieved for a length-1 array. Note that
// because actually passing copies of subarrays costs time and space, we instead pass low and
// high indices that describe the relevant slice of the overall array. In this case, the majority
// element for a length-1 slice is trivially its only element, so the recursion stops there. If the
// current slice is longer than length-1, we must combine the answers for the slice's left and
// right halves. If they agree on the majority element, then the majority element for the overall
// slice is obviously the same. If they disagree, only one of them can be "right",so we need to
// count the occurrences of the left and right majority elements to determine which subslice's
// answer is globally correct. The overall answer for the array is thus the majority element
// between indices 0 and n.

public class MajorityByDivideAndConquer {
    public static int countInRange(int[] nums, int num, int low, int high){
        int count = 0;
        for(int i = low; i <= high; i++){
            if(nums[i] == num){
                count++;
            }
        }
        return count;
    }
    public static int majorityElement(int[] nums, int low, int high){
        // Base case - the only element in the array of size 1 is the majority element
        if(low == high){
            return nums[low];
        }
        // Divide the array into two halves (recurse on the left and right halves of the slice)
        int mid = low + (high-low) / 2;
        int left = majorityElement(nums, low, mid);
        int right = majorityElement(nums, mid+1, high);
        // If the left and right halves agree on the majority element, then the majority element for the
        // overall slice is obviously the same -
        if(left == right){
            return left;
        }
        // If the left and right halves disagree, only one of them can be "right", so
        // we need to count the occurrences of the left and right majority elements to 
        // determine which subslice's answer is globally correct.
        else{
            int leftCount = countInRange(nums, left, low, high);
            int rightCount = countInRange(nums, right, low, high);
            return (leftCount > rightCount) ? left : right;
        }
    }
    public static int majority(int[] nums){
        return majorityElement(nums, 0, nums.length-1);
    }
    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majority(nums)); // Output: 2
    }
}