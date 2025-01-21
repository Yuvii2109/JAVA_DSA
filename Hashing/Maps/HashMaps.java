import java.util.HashMap;

public class HashMaps {
    /*
     * Operations of hashMaps -
     * 1. put(key, value) - inserts a new key-value pair into the map - O(1)
     * 2. get(key) - returns the value associated with the given key - O(1)
     * 3. remove(key) - removes the key-value pair with the given key - O(1)
     * 4. containsKey(Key) - returns true if the map contains the given key - O(1)
     * 5. size() - returns the number of key-value pairs in the map - O(1)
     * 6. clear() - removes all key-value pairs from the map - O(n)
     * 7. isEmpty() - checks if the hashMap is empty or not - O(1) 
     */
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();
        // Insert key-value pairs into the map
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        System.out.println(map); // Data is stored randomly

        // Retrieve a value from the map
        System.out.println(map.get("one")); 
        System.out.println(map.get("four"));
        System.out.println(map.get("five"));

        // Check if a key exists in the map 
        System.out.println(map.containsKey("one"));
        System.out.println(map.containsKey("five"));

        // Remove a key-value pair from the map
        map.remove("two");
        System.out.println(map);

        // Determine the size of the map 
        System.out.println(map.size());

        // Check if the map is Empty 
        System.out.println(map.isEmpty());

        // Clear all the key-value pairs from the map
        map.clear();
        System.out.println(map);
    }
}