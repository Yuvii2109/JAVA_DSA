public class ReverseSelectionSort {
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int maxIndex = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
        System.out.println("\nSorted array is - ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
    public static void main(String args[]){
        int[] arr = {3,6,2,1,8,7,4,5,3,1};
        selectionSort(arr);
    }
}