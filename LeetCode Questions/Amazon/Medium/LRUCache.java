// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

// Implement the LRUCache class -

// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

// Example 1 -

// Input -
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]

// Explanation -
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public class Node {
        int key, value;
        Node previous, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Dummy head and tail nodes to avoid edge case checks
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    // HashMap to hold key to node mapping for O(1) access
    Map<Integer, Node> map = new HashMap<>();
    int capacity; // Maximum capacity of the LRU Cache

    // Constructor to initialize the LRU Cache with given capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // Initially link head and tail
        head.next = tail;
        tail.previous = head;
    }
    
    // Get the value associated with the key if present, otherwise return -1
    public int get(int key) {
        if(map.containsKey(key)) {
            // Retrieve the node from the map
            Node node = map.get(key);
            // Remove the node from its current position
            remove(node);
            // Insert the node at the head (marking it as most recently used)
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    // Put a key-value pair into the cache, update if key already exists
    public void put(int key, int value) {
        // If the key already exists, remove it first to update its value and move to head later
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        // If the cache is full, remove the least recently used element (node before tail)
        if(map.size() == capacity){
            remove(tail.previous);
        }
        // Insert the new node with key and value at the head
        insert(new Node(key, value));
    }

    // Remove a node from the doubly linked list and HashMap
    public void remove(Node node) {
        // Remove the node from the map using its key
        map.remove(node.key);
        // Bypass the node in the list by adjusting the previous and next pointers
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    // Insert a node right after the head (marking it as most recently used) and add to the map
    public void insert(Node node) {
        // Add the node to the map
        map.put(node.key, node);
        // Place node after head
        node.next = head.next;
        // Update the previous pointer of the old first node
        node.next.previous = node;
        // Link head to the new node
        head.next = node;
        // Set the previous pointer of the new node to head
        node.previous = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */