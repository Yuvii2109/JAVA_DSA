public class KadaneUpgraded {
    public static void kadanes(int arr[]){
        int max_so_far = arr[0];
        int current_sum = arr[0];
        for(int i = 1; i < arr.length; i++){
            current_sum = Math.max(arr[i], current_sum + arr[i]);
            max_so_far = Math.max(max_so_far, current_sum);
        }
        System.out.println("\nMaximum sub array sum is - " + max_so_far + "\n");
    }
    public static void main(String args[]){
        int arr[] = {-2, -3, -4, -1, -2, -1, -5, -3};
        kadanes(arr);
    }
}