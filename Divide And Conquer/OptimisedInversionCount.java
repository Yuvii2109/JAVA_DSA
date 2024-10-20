//  Approach 2- Modified Merge Sort
//  Idea - Suppose the number of inversions in the left half and right half
//  of the array(let be inv1 and inv2); what kinds of inversions are not 
//  accounted for in Inv1+Inv2? The answer is – the inversions that need
//  to be counted during the merge step. Therefore, to get the total number
//  of inversions that need to be added are the number of inversions in the
//  left subarray, right subarray, and merge(). Basically, for each array 
//  element, count all elements more than it to its left and add the count
//  to the output. This whole magic happens inside the merge function of merge sort.

//  Algorithm:
//  ● Split the given input array into two halves, left and right similar
//  to merge sort recursively.
//  ● Count the number of inversions in the left half and right half along
//  with the inversions found during the merging of the two halves.
//  ● Stop the recursion, only when 1 element is left in both halves.
//  ● To count the number of inversions, we will use a two pointers
//  approach. Let us consider two pointers i and j, one pointing to 
//  the left half and the other pointing towards the right half.
//  ● While iterating through both the halves, if the current element A[i]
//  is less than A[j], add it to the sorted list, else increment the count by mid – i.
//  Time complexity - O(nlogn)

public class OptimisedInversionCount {
    public static int merge(int arr[], int left, int mid, int right){
        int i = left, j = mid + 1, k = 0;
        int invCount = 0;
        int temp[] = new int[(right - left + 1)];

        // Merge the two subarrays
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1); // All elements from i to mid in the left subarray are greater than arr[j]
            }
        }

        // Copy the remaining elements of the left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements of the right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted subarray back into the original array
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }

    public static int mergeSort(int arr[], int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            invCount += mergeSort(arr, left, mid);
            invCount += mergeSort(arr, mid + 1, right);

            invCount += merge(arr, left, mid, right); // mid is passed correctly here
        }
        return invCount;
    }

    public static int getInversions(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 6, 4, 5};
        System.out.println("Inversion Count - " + getInversions(arr));
    }
}