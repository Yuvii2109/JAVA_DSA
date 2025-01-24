// Given an integer array of size n, find all the elements that appear 
// more than n/3 times.

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // if (map.containsKey(arr[i])) {
            //     map.put(arr[i], map.get(arr[i]) + 1);
            // }else{
            //     map.put(arr[i], 1);
            // }
            // This can be written in a more optimised way as - 
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // Print the elements that appear more than n/3 times
        // Set<Integer> keySet = map.keySet() likhne ki jagah neeche wala
        // tareeka bhi use kr skte hain...
        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 3) {
                System.out.println(key + " is Majority Element");
            }
        }
    }   
}