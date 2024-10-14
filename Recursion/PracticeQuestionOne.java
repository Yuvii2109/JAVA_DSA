import java.security.Key;

public class PracticeQuestionOne {
    //  For a given integer array of size N. You have to find all the occurrences
    //  (indices) of a given element (Key) and print them. Use a recursive function to solve this
    //  problem.
    public static void findKey(int[] arr, int key, int index) {
        if(index == arr.length){
            return;
        }
        if(arr[index] == key){
            System.out.print(key + " found on position - " + (index+1) + "\n");
        }
        findKey(arr, key, index+1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 2, 7, 6, 8, 2};
        int key = 2;
        findKey(arr, key, 0);
    }
}