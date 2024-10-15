public class MergeSort {
    public static void printArr(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void mergeSort(int arr[], int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start)/2;   // Mid nikalne ka optimised treeka hai bhai dekhlio
        // Hai yeh bhi (start + end)/2 or kuch nahi chahe toh simplefy krke dekhle
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }
    public static void merge(int arr[], int start, int mid, int end){
        // left(0,3) = 4; right(4,6) = 3; -> total 7 => 6 - 0 + 1
        int temp[] = new int[end - start + 1];
        int i = start; // Iterator for the left part
        int j = mid + 1; // Iterator for the right part
        int k = 0; // Iterator for the temp array
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // Yeh sb toh theek hai but agr kuch bach gye toh uske liye yehle - 
        // Left part
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        // Right part
        while(j <= end){
            temp[k++] = arr[j++];
        }
        // Copying temp back to arr
        for(k = 0, i = start; k < temp.length; i++, k++){
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}