import java.util.Arrays;

public class InBuiltSorting {
    public static void main(String[] args) {
        int[] arr = {23,5,21,16,19};
        Arrays.sort(arr);
        System.out.println("\nSorted array is - ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}

// Time complexity - O(nlogn)