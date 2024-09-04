public class LinearSearch {
    public static int LSearch(int arr[], int key){
        for(int i=0; i < arr.length; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int numbers[] = {1, 2, 3, 4, 5, 6, 7};
        int key = 3;
        int index = LSearch(numbers, key);
        if(index == -1){
            System.out.println("\nElement is not present in array\n");
        }else{
            System.out.println("\nElement is present at " + (index+1) + " position\n");
        }
    }
}