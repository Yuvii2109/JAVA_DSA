// Dekh bhai shayad ek baar ko smjhne main thoda time lage pr yahan tk pohch gya
// Aage bhi kr hi lega toh iss question main hume ek key milegi jise hume 
// ArrayList main search krna hai or uss key ke just immediately next element ko
// jo sbse zyda baar just immediate baad aaya ho and bss use print krne ka hai rey baba

import java.util.ArrayList;

public class MostFrequentNumberFollowingKey {
    public static int mostFrequentNumberFollowingKey(ArrayList<Integer> nums, int key){
        int[] result = new int[1000]; // This array is used to count occurrences 
        // of numbers following the key, result[i] will store the frequency
        // of the number i+1 appearing immediately after key.

        for(int i=0; i<nums.size()-1; i++){
            if(nums.get(i) == key){
                result[nums.get(i+1)-1]++;
            }
        }
        // Example:
        // For nums = [1, 2, 3, 2, 3, 4] and key = 2 :-
        // At i = 1, nums.get(i) == key (2). Increment 
        // result[nums.get(2) - 1] → result[3 - 1] → result[2]++.
        // At i = 3, nums.get(i) == key (2). Increment 
        // result[nums.get(4) - 1] → result[3 - 1] → result[2]++.
        // After this loop: result = [0, 0, 2, ...] (number 3 appears 
        // twice after key 2).

        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0; i<1000; i++){
            if(result[i] > max){
                max = result[i];
                ans = i+1;
            }
        }
        // Traverse the result array to find the index with the highest 
        // value (max), indicating the most frequent number.
        // ans = i + 1 because the index i in the result array 
        // corresponds to the number i + 1 in the original list.

        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);
        list.add(200);
        list.add(1);
        list.add(100);
        int key = 1;
        System.out.println(mostFrequentNumberFollowingKey(list, key));
    }
}

// Assumption: The numbers in nums are within the range 1 to 1000.
// Limitation: If the input contains numbers greater than 1000, the 
// code will throw an ArrayIndexOutOfBoundsException.