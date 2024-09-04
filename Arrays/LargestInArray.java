import java.util.*;

public class LargestInArray {
    public static int getLargest(int arr[]){
        int largest = Integer.MIN_VALUE; // -Infinity
        for(int i = 0; i < arr.length; i++){
            if(largest < arr[i]){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of elements in the array - ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            System.out.print("Enter element " + (i+1) + " - ");
            arr[i] = sc.nextInt();
        }
        System.out.println("\nLargest element in the array is - " + getLargest(arr) + "\n");
        sc.close();

    }
}