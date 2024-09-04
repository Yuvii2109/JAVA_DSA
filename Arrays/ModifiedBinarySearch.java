public class ModifiedBinarySearch {

    // To find the index of the target element in a rotated sorted array
    public static int findInWhichPart(int arr[], int target){
        // Since it's a sorted list, minimum index will have minimum value
        int min = minSearch(arr);
        // Finding in sorted left 
        if(arr[min] <= target && target <= arr[arr.length-1]){
            return search(arr, min, arr.length-1, target);
        }else{
            // Finding in sorted right
            return search(arr, 0, min, target);
        }
    }

    // Binary search to find target in left to right boundary
    public static int search(int arr[], int left, int right, int target){
        int l = left;
        int r = right;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }

    // Smallest element index
    public static int minSearch(int arr[]){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;

            // Iss formula ki vjh yeh ki - 
            // Using (left + right)/2 - 
            // left + right can be overflow for large array like - 
            // mid = (2000000000 + 2000000005) / 2;
            // mid = 4000000005 / 2; - This might cause overflow in some cases.
            
            // Now using - left + (right - left)/2 - 
            // mid = 2000000000 + (2000000005 - 2000000000) / 2;
            // mid = 2000000000 + 5 / 2;
            // mid = 2000000000 + 2;
            // mid = 2000000002;

            // Toh mota moti ikko hi gall aa...

            if(mid > 0 && arr[mid-1] > arr[mid]){
                return mid;
            }else if(arr[left] <= arr[mid] && arr[mid] > arr[right]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String args[]){
        int arr[] = {0,1,2,4,5,6,7};
        int target = 5;
        System.out.println();
        System.out.println(findInWhichPart(arr, target));
        System.out.println();
    }
}