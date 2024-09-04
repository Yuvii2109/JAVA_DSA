public class PrefixMethod {
    // Dekh bhai seedhi baat boloon toh pichla method boht lul tha
    // Kyunki uski time complexity boht zyda thi jo ki achi baat nahi hai
    // Isliye here we present an optimised approach jo ki hai - 
    public static void maxSubarraySum(int arr[]){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i = 0; i < arr.length; i++){
            int start = i;
            for(int j = i; j < arr.length; j++){
                int end = j;
                sum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
                if(maxSum < sum){
                    maxSum = sum;
                }
            }
        }
        System.out.println("\nMaximum sum - " + maxSum + "\n");
    }
    public static void main(String args[]){
        int arr[] = {1, -2, 6, -1, 3};
        maxSubarraySum(arr);
    }
    // Toh dekho bhai iss wale method ki O(n^2) hogi jbki pehle wale 
    // method ki O(n^3) thi toh yehi wala better hua na bhayyyy
}