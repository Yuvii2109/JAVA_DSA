import java.util.HashSet;
import java.util.Scanner;

public class NumberRepititionHashset {
    public static boolean repeat(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(set.contains(arr[i])){
                return true;
            }else{
                set.add(arr[i]);
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of elements in the array - ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter the element " + (i+1) + " - ");
            arr[i] = sc.nextInt();
        }
        System.out.println(repeat(arr));
        System.out.println();
        sc.close();
    }
}

// Dekh ab iska O(n) hai preshan nahi hone ka biddu... aage pdhege...