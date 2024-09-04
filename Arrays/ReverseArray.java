import java.util.*;

public class ReverseArray {
    public static void reverse(int arr[]){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of elements you want in the array - ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter element " + (i+1) + " - ");
            arr[i] = sc.nextInt();
        }
        reverse(arr);
        System.out.println("\nReverse of the array is - ");
        for(int i = 0; i < arr.length; i++){
            if(i<arr.length-1){
                System.out.print(arr[i] + ", ");
            }else{
                System.out.print(arr[i]);
            }
        }
        System.out.println("\n");
        sc.close();
    }
}