public class PairsInArray {
    public static void pairs(int arr[]){
        int totalPairs = 0;
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            int curr = arr[i];
            for(int j = i+1; j < arr.length; j++){
                System.out.print("( " + curr + ", " + arr[j] + " )");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("Total pairs - " + totalPairs + "\n");
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5};
        pairs(arr);
    }
}