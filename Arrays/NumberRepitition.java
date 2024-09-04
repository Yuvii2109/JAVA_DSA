import java.util.Scanner;

public class NumberRepitition {
    public static void repitition(int arr[]){
        boolean a = false;
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] == arr[j]){
                    a = true;
                }
            }
        }
        if(a == true){
            System.out.println("There are duplicate numbers in the array\n");
        }else{
            System.out.println("There are no duplicate numbers in the array\n");
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of elements in the array - ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter element " + (i+1) + " - ");
            arr[i] = sc.nextInt();
        }
        repitition(arr);
        sc.close();
    }
}

// O(n^2) hai bhai ro le kahin jaakr... kyuki code accept nahi hone wale
// Hashset se O(n) se solve ho jaaya krega koini chinta na kr ... 