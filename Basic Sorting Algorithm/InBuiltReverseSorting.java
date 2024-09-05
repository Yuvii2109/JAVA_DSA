import java.util.Arrays;
import java.util.Collections;

public class InBuiltReverseSorting {
    public static void main(String[] args) {
        
        // Iss case main Integer use hoga 

        Integer[] arr = {23,5,21,16,19};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("\nSorted array is - ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}