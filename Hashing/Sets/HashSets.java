// Collection of unique elements, unorderly arranged, can include Null.

import java.util.HashSet;

public class HashSets {
    public static void main(String[] args) {
        // Create a HashSet
        HashSet<String> hashSet = new HashSet<>();
        // Adding - O(1)
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple");
        hashSet.add(null);
        hashSet.add(null);
        System.out.println(hashSet);
        // Contains - O(1) 
        System.out.println(hashSet.contains("Apple"));
        System.out.println(hashSet.contains("Banana"));
        System.out.println(hashSet.contains("Grapes"));
        // Remove - O(1)
        hashSet.remove("Apple");
        System.out.println(hashSet);
        // Size - O(1)
        System.out.println(hashSet.size());
        // Clear - O(n)
        hashSet.clear();
        System.out.println(hashSet);
        // isEmpty() - O(1)
        System.out.println(hashSet.isEmpty());
    }
}