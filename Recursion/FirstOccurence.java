public class FirstOccurence {
    public static int firstOccurence(int arr[], int key, int i){
        if(i == arr.length) return -1;
        if(arr[i] == key) return i;
        return firstOccurence(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[] = {8, 3, 6, 9, 5, 10, 9, 5, 3};
        System.out.println("\nFirst occurence at Position - " + (firstOccurence(arr, 5, 0)+1) + "\n");
    }
}