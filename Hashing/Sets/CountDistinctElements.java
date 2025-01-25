import java.util.TreeSet;

public class CountDistinctElements {
    public static int countDistinctElements(int[] arr) {
        TreeSet<Integer> nums = new TreeSet<>();
        for(int i = 0; i < arr.length; i++){
            nums.add(arr[i]);
        }
        return nums.size();
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        System.out.println("Number of distinct numbers - " + countDistinctElements(arr));
    }
}