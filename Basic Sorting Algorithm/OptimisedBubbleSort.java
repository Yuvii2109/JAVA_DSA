import java.util.Scanner;

public class OptimisedBubbleSort {
    public static void bubbleSortOptimised(int arr[]){
        for(int i = 0; i < arr.length-1; i++){
            boolean swapped = false;
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped = false){
                break;
            }
        }
        System.out.println("\nSorted array is - ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of elements in the array - ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter element " + (i+1) + " - ");
            arr[i] = sc.nextInt();
        }
        bubbleSortOptimised(arr);
        sc.close();
    }
}