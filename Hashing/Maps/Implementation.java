import java.util.ArrayList;
import java.util.LinkedList;

public class Implementation {
    // Creating a generic class
    public static class HashMap<K, V>{
        // Node class to store key-value pairs
        public class Node {
            K key;
            V value;
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // Number of key-value pairs
        private int N; // Number of buckets
        private LinkedList<Node>[] buckets; // Array of LinkedLists for separate chaining

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.n = 0;
            this.N = 16; // Initial number of buckets
            this.buckets = new LinkedList[N]; // Initialize buckets array
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // Hash function to get bucket index
        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        // Method to search for key in a specific bucket
        private int searchInLL(K key, int bucketIndex) {
            LinkedList<Node> LL = buckets[bucketIndex];
            for (int i = 0; i < LL.size(); i++) {
                Node node = LL.get(i);
                if (node.key.equals(key)) {
                    return i; // Return index in the linked list
                }
            }
            return -1; // Key not found in this bucket
        }

        // Method to rehash the HashMap when load factor exceeds 2.0
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            N = 2 * N; // Double the number of buckets
            buckets = new LinkedList[N]; // Create new bucket array
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
            // Move existing elements to the new buckets array
            for (LinkedList<Node> oldLL : oldBuckets) {
                for (Node node : oldLL) {
                    int newIndex = hashFunction(node.key); // Compute new index
                    buckets[newIndex].add(node); // Add node to new bucket
                }
            }
        }

        // Method to insert or update a key-value pair
        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);
            if (dataIndex != -1) {
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value; // Update value if key already exists
            } else {
                Node newNode = new Node(key, value);
                buckets[bucketIndex].add(newNode); // Add new node to the bucket
                n++;
            }
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash(); // Rehash if load factor exceeds 2.0
            }
        }

        // Method to check if key exists in the HashMap
        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            return searchInLL(key, bucketIndex) != -1;
        }

        // Method to remove key-value pair from HashMap
        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);
            if (dataIndex != -1) {
                Node node = buckets[bucketIndex].remove(dataIndex);
                n--;
                return node.value;
            } else {
                return null; // Key not found
            }
        }

        // Method to get value associated with key
        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);
            if (dataIndex != -1) {
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            } else {
                return null; // Key not found
            }
        }

        // Method to return list of all keys in the HashMap
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> LL : buckets) {
                for (Node node : LL) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        // Method to check if HashMap is empty
        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        // Example usage
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("1", 1);
        hm.put("2", 2);
        hm.put("3", 3);

        // Print all key-value pairs in the HashMap
        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key + " - " + hm.get(key));
        }
    }
}