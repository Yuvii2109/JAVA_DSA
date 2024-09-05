import java.util.Scanner;

public class CountingSorting {
    public static void countingSort(int[] arr){
        int max = Integer.MIN_VALUE;  
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        } 
        int[] count = new int[max+1];
        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }
        int j = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
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
        countingSort(arr);
        sc.close();
    }
}