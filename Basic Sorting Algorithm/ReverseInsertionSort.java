public class ReverseInsertionSort {
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int current = arr[i];
            int previous = i-1;
            while(previous >= 0 && arr[previous] < current){
                arr[previous+1] = arr[previous];
                previous--;
            }
            arr[previous+1] = current;
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
    public static void main(String args[]){
        int[] arr = {3,6,2,1,8,7,4,5,3,1};
        insertionSort(arr);
    }
}