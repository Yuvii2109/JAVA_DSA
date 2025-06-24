/*
    Given an array of strings words and an integer k, return the k most frequent strings.

    Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

    Example 1 -
        Input - words = ["i","love","leetcode","i","love","coding"], k = 2
        Output - ["i","love"]
        Explanation - "i" and "love" are the two most frequent words.
        Note that "i" comes before "love" due to a lower alphabetical order.

    Example 2 -
        Input - words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
        Output - ["the","is","sunny","day"]
        Explanation - "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
*/

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        // Count Frequency
        Map<String, Integer> freq = new HashMap<>();
        for(String w : words){
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        // Min-heap - (word, count), ordered so that
        // - lowest count is first
        // - if counts equal, lexicographically largest is first, so it gets kicked out before a lexicographically smaller one.
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String w1, String w2){
                int c1 = freq.get(w1);
                int c2 = freq.get(w2);
                if(c1 != c2){
                    return Integer.compare(c1, c2); // Smaller count first
                }else{
                    return w2.compareTo(w1); // Larger word first
                }
            }
        });
        // Push each unique word onto the heap, keeping size ≤ k
        for (String w : freq.keySet()) {
            pq.offer(w);
            if (pq.size() > k) {
                pq.poll();  // remove the "least" among the top k
            }
        }
        // Build result list by polling and inserting at front
        List<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll());
        }

        return result;
    }
}