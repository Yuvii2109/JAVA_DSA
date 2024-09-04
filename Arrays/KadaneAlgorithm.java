public class KadaneAlgorithm {
    public static void kadanes(int arr[]){
        int max_so_far = Integer.MIN_VALUE;
        int current_sum = 0;
        for(int i = 0; i < arr.length; i++){
            current_sum += arr[i];
            if(current_sum < 0){
                current_sum = 0;
            }
            max_so_far = Math.max(current_sum, max_so_far);
        }
        System.out.println("\nMaximum sub array sum is - " + max_so_far + "\n");
    }
    public static void main(String args[]){
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        kadanes(arr);
    }
    // Toh dekho brother yeh hota ha Kadane's algorithm 
    // iski time complexity - O(n) hai toh bhai ofc sbka fav hoga
    // Bas ek kami hai yeh sirf negative array ke liye kaam ni krega
    // Uske liye pesh kroonga iska upgraded version...
}