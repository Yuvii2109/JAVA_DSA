import java.util.Scanner;

public class InsertionSorting {
    public static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int current = arr[i];
            int previous = i-1;

            // Determining the correct position to insert
            while(previous >= 0 && arr[previous] > current){
                arr[previous+1] = arr[previous];
                previous--;
            }

            // Insertion
            arr[previous+1] = current;
        }
        System.out.println();
        for(int i = 0; i < n; i++){
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
        insertionSort(arr);
        sc.close();
    }
}