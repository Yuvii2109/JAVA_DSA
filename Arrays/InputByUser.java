import java.util.*;

public class InputByUser {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of elements you want to input in the array - ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter the element " + (i+1) + " - ");
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            if(i<n-1){
                System.out.print(arr[i] + ", ");
            }else{
                System.out.println(arr[i]);
            }
        }
        sc.close();
    }
}