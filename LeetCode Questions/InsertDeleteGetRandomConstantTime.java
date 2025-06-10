/*
    Implement the RandomizedSet class -
        RandomizedSet() Initializes the RandomizedSet object.
        bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
        bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
        int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
        You must implement the functions of the class such that each function works in average O(1) time complexity.

    Example 1 -
        Input - 
            ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
            [[], [1], [2], [2], [], [1], [2], []]
        Output - [null, true, false, true, 2, true, false, 2]
        Explanation - 
            RandomizedSet randomizedSet = new RandomizedSet();
            randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
            randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
            randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
            randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
            randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
            randomizedSet.insert(2); // 2 was already in the set, so return false.
            randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomConstantTime {
    // Maps a value to its index in the 'values' list
    private final Map<Integer, Integer> idxMap;
    // Stores the current set of values
    private final List<Integer> values;
    // Random generator
    private final Random rand;

    public RandomizedSet() {
        // Initializing data structure
        idxMap = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (idxMap.containsKey(val)) {
            return false;
        }
        // Append to end of 'values' list
        idxMap.put(val, values.size());
        values.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        Integer index = idxMap.get(val);
        if(index == null){
            return false;
        }
        // Move the last element into the 'hole' at index
        int lastVal = values.get(values.size() - 1);
        values.set(index, lastVal);
        idxMap.put(lastVal, index);

        // Remove the last element
        values.remove(values.size() - 1);
        idxMap.remove(val);
        return true;
    }
    
    // Returns a random element from the current set of elements. Each element has equal probability of being returned.
    public int getRandom() {
        int randomIndex = rand.nextInt(values.size());
        return values.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such -
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */