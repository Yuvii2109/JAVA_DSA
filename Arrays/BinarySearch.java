// Basic requirement - array sorted hona chahiye life ho ya na ho...

public class BinarySearch {
    public static int binaryS(int arr[], int key){
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] < key){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8};
        int key = 7;
        int result = binaryS(arr, key);
        System.out.println("\nIndex for the key is - " + result);
    }
}