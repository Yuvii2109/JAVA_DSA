public class SubArraySum {
    public static int getLargest(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(largest < arr[i]){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static void SubSum(int arr[]){
        int sum = 0, ts = 0;
        int sumArr[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                for(int k = i; k <= j; k++){
                    System.out.print(arr[k]);
                    sum += arr[k];
                }
                System.out.println(" | Sum - "+ sum);
                sumArr[i] = sum;
                ts++;
                sum = 0;
            }
            System.out.println();
        }
        System.out.print("\nTotal number of subarrays - " + ts + "\n");
        System.out.println("Largest subarray sum - " + getLargest(sumArr) + "\n");
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println();
        SubSum(arr);
    }
}