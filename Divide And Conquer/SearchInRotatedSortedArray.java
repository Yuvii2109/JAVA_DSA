public class SearchInRotatedSortedArray {
    public static int search(int arr[], int target, int start, int end){
        if(start > end) return -1;
        int middle = start + (end - start)/2;
        // Agr pehli baar main mil jaaye 
        if(arr[middle] == target){
            return middle;
        }
        if(arr[start] <= arr[middle]){
            // Target on First part
            if(arr[start] <= target && target < arr[middle]){
                // Left part - 
                return search(arr, target, start, middle-1);
            }else{
                // Right part -
                return search(arr, target, middle + 1, end);
            }
        }else{
            // Target on Second part
            if(arr[middle] <= target && target <= arr[end]){
                // Right part -
                return search(arr, target, middle + 1, end);
            }else{
                // Left part -
                return search(arr, target, start, middle-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0; // Output -> 4
        int targetIndex = search(arr, target, 0, arr.length-1);
        System.out.println(targetIndex);
    }
}