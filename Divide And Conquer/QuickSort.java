public class QuickSort {
    public static void printArr(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void quickSort(int arr[], int start, int end){
        if(start >= end){
            return;
        }
        // Last element -
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex-1); // left part
        quickSort(arr, pivotIndex+1, end); // right part
    }
    public static int partition(int arr[], int start, int end){
        int pivot = arr[end];
        int i = start - 1; // To make place for elements smaller than pivot
        for(int j = start; j < end; j++){
            if(arr[j] < pivot){
                i++; // Jagah bnane ke liye
                // Swapping
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        // Swapping pivot element with the element at i++
        int temp = pivot;
        arr[end] = arr[i];
        arr[i] = temp;
        return i;
    }
    public static void main(String args[]){
        int arr[] = {6, 3, 9, 8, 2, 5};
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}

// Average case main O(nlogn) but worst case main it can be O(n^2) if the 
// pivot is the smallest or largest element in the array. To avoid this, we
// can use random pivot or use median of three pivot selection.