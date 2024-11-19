public class InArrays {
    public static void changeArr(int arr[], int i, int val){
        // Base case
        if (i == arr.length) {
            printArr(arr); // 1 2 3 4 5
            return;
        }else{
            arr[i] = val;
            changeArr(arr, i+1, val+1); // Function call step
            arr[i] -= 2; // Backtrack step
        }
    }
    public static void printArr(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
    public static void main(String args[]){
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr); // -1 0 1 2 3
    }
}