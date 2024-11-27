// A number x is lonely when it appears only once, and
// no adjacent numbers (i.e. x + 1 and x - 1) appear in the arraylist.
// Sample Input 1 : nums = [10,6,5,8]
// Sample Output 1 : [10,8]
// Explanation :- 10 is a lonely number since it appears exactly once and 
// 9 and 11 does not appear in nums. 8 is a lonely number since it appears 
// exactly once and 7 and 9 does not appear in nums.  5 is not a lonely 
// number since 6 appears in nums and vice versa.
// Hence, the lonely numbers in nums are [10, 8].
// Note that [8, 10] may also be returned.

import java.util.*;

public class LonelyNumber {
    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums){
        Collections.sort(nums); // The input list nums is sorted to bring 
        // numbers into ascending order. Sorting ensures that we can check 
        // neighbors efficiently since they are directly adjacent.

        ArrayList<Integer> lonely = new ArrayList<Integer>();

        for(int i = 1; i < nums.size()-1; i++){
            if(nums.get(i-1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i+1)){
                lonely.add(nums.get(i));
            }
        }
        // nums.get(i - 1) + 1 < nums.get(i): Ensures the number is at 
        // least 2 greater than its left neighbor.
        // nums.get(i) + 1 < nums.get(i + 1): Ensures the number is at 
        // least 2 smaller than its right neighbor.

        if(nums.size() == 1){
            lonely.add(nums.get(0));
        }
        // If the list has only one element, it is lonely by definition.

        if(nums.size() > 1){
            // Well this is for the addition of the first and the last element in 
            // the list provided they are lonely XD
            if(nums.get(0) + 1 < nums.get(1)){
                lonely.add(nums.get(0));
            }
            if(nums.get(nums.size()-2) + 1 < nums.get(nums.size()-1)){
                lonely.add(nums.get(nums.size()-1));
            }
        }
        // First element:
        // Check if it is at least 2 smaller than the second element 
        // (nums.get(0) + 1 < nums.get(1)). If true, add it to the lonely list.
        // Last element:
        // Check if it is at least 2 greater than the second-to-last element 
        // (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)).
        // If true, add it to the lonely list.

        return lonely;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        System.out.println(findLonely(list));
    }
}