// Given a string s, sort it in decreasing order based on the 
// frequency of the characters. The frequency of a character is 
// the number of times it appears in the string. Return the sorted 
// string. If there are multiple answers, return any of them.

// Sample Input 1 - s = "cccaaa"
// Sample Output 1 - "aaaccc"
// Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" 
// are valid answers. Note that "cacaca" is incorrect, as the same 
// characters must be together.

// Sample Input 2 - s = "tree"
// Sample Output 2 -"eert"
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is 
// also a valid answer.

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortByFrequency {

    public String frequencySort(String s) {
        // Step 1 - Create a HashMap to count the frequency of each character
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2 - Use a PriorityQueue to sort characters by their frequency in descending order
        PriorityQueue<HashMap.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        // Add all entries from the HashMap into the PriorityQueue
        maxHeap.addAll(frequencyMap.entrySet());

        // Step 3 - Build the resulting string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            HashMap.Entry<Character, Integer> entry = maxHeap.poll();
            char character = entry.getKey();
            int frequency = entry.getValue();

            // Append the character 'frequency' times
            for (int i = 0; i < frequency; i++) {
                result.append(character);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SortByFrequency sorter = new SortByFrequency();

        // Test Case 1 -
        String s1 = "cccaaa";
        System.out.println("Sample Input 1 Result - " + sorter.frequencySort(s1));

        // Test Case 2 -
        String s2 = "tree";
        System.out.println("Sample Input 2 Result - " + sorter.frequencySort(s2));

        // Test Case 3 -
        String s3 = "Aabb";
        System.out.println("Sample Input 3 Result - " + sorter.frequencySort(s3));
    }
}

// Time complexity - O(n + klogk)