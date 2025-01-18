public class HeapSort {
    public static void heapify(int arr[], int i, int n) {
        int largest = i; // Initialize largest as root
        int left = 2*i + 1;
        int right = 2*i + 2;
        // Check if left child of root exists and is greater than root
        if (left < n && arr[largest] < arr[left]){
            largest = left;
        }
        // Check if right child of root exists and is greater than root
        if (right < n && arr[largest] < arr[right]){
            largest = right;
        }
        // Change root, if needed
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // Heapify the root.
            heapify(arr, largest, n);
        }
    }
    // heapify is a recursive method that ensures the subtree rooted at 
    // index 'i' in the array "arr" satisfies the heap property, where each 
    // parent node is greater than or equal to its children.
    // It takes parameters arr (the array to be sorted), i (the index of 
    // the root of the subtree to heapify), and n (the size of the heap/array).
    // largest is initially set to i (root index).
    // left and right calculate the indices of the left and right children
    // of i. If left exists within the array (left < n) and is greater 
    // than largest, largest is updated to left.
    // Similarly, if right exists within the array and is greater than 
    // largest, largest is updated to right.
    // If largest is not equal to i, swap arr[i] and arr[largest] to 
    // maintain the heap property, then recursively call heapify on the 
    // affected subtree (heapify(arr, largest, n)).

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, i, n);
        }
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            heapify(arr, 0, i);
        }
    }    
    // heapSort method performs the heap sort algorithm on the array arr.
    // It starts by building a max heap from the array. This is done by 
    // calling heapify on all non-leaf nodes 
    // (for (int i = n / 2 - 1; i >= 0; i--)).
    // Once the heap is built, it repeatedly extracts the maximum element 
    // (root of the heap, which is at index 0 after the first heapify) and 
    // places it at the end of the array.
    // After each extraction, it calls heapify on the reduced heap (from 
    // index 0 to i) to maintain the heap property.
    // This process continues until the entire array is sorted in ascending 
    // order.

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 21};
        heapSort(arr);
        System.out.println("Sorted array is - ");
        printArray(arr);
    }
}

// Time complexity - O(nlogn)