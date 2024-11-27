import java.security.Key;
import java.util.ArrayList;

public class PairSumTwo {
    public static boolean pairSumTwo(ArrayList<Integer> list, int target){
        int breakPoint = -1;
        int n = list.size();
        // The breakpoint is the index where the array transitions from a
        // higher number to a lower number, indicating the rotation point.
        // Example for list = [11, 15, 6, 8, 9, 10]:
        // list[1] > list[2] → breakPoint = 1.
        // This divides the array into two parts:
        // [11, 15] (largest elements before rotation).
        // [6, 8, 9, 10] (smallest elements after rotation).
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > list.get(i+1)){
                breakPoint = i;
                break;
            }
        }
        // If the array is already sorted, there is no rotation.
        int left = breakPoint+1; // Smallest
        int right = breakPoint; // Largest
        // left starts from the smallest element (6 in the example).
        // right starts from the largest element (15 in the example).
        while(left != right){
            int sum = list.get(left) + list.get(right);
            if(sum == target){
                return true;
            }else if(sum < target){
                left = (left+1)%n;
            }else{
                right = (right-1+n)%n;
            }
        }
        // Key Idea: The sum of list[left] and list[right] determines how 
        // pointers are moved:
        // If sum == target, return true.
        // If sum < target, increment left (move to the next larger number 
        // in the array).
        // If sum > target, decrement right (move to the next smaller number 
        // in the array).

        // Circular indexing is handled using modulo (%):
        // (left + 1) % n ensures that left wraps around to 0 if it 
        // exceeds the array size.
        // (right - 1 + n) % n ensures that right wraps around to the 
        // last index if it becomes negative.
        return false;
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(pairSumTwo(list, target));
    }
}

// Toh bhai iski time complexity is O(n)