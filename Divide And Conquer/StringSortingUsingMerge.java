public class StringSortingUsingMerge {
    // Apply Merge sort to sort an array of Strings.(Assume that all 
    // the characters in all the Strings are in lowercase). (EASY)
    // Sample Input : arr = { "sun", "earth", "mars", "mercury"}
    // Sample Output : arr = { "earth", "mars", "mercury", "sun"}
    public static String[] mergeSort(String[] arr, int low, int high){
        if(low == high){
            String[] A = {arr[low]};
            return A;
        }
        int mid = (low + high) / 2;
        String[] left = mergeSort(arr, low, mid);
        String[] right = mergeSort(arr, mid+1, high);
        String[] array = merge(left, right);
        return array;
    }
    static String[] merge(String arr1[], String arr2[]){
        int m = arr1.length;
        int n = arr2.length;
        String[] arr3 = new String[m+n];
        int index = 0;
        int i = 0, j = 0;
        while(i < m && j < n){
            if(isAlphabeticallySmaller(arr1[i], arr2[j])){
                arr3[index] = arr1[i];
                i++;
                index++;
            }else{
                arr3[index] = arr2[j];
                j++;
                index++;
            }
        }
        while(i < m){
            arr3[index] = arr1[i];
            i++;
            index++;
        }
        while(j < n){
            arr3[index] = arr2[j];
            j++;
            index++;
        }
        return arr3;
    }
    // Return true if str1 appears before str2 in alphabetical order
    static boolean isAlphabeticallySmaller(String str1, String str2){
        if(str1.compareTo(str2) < 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String[] arr = { "sun", "earth", "mars", "mercury" };
        String[] a = mergeSort(arr, 0, arr.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}