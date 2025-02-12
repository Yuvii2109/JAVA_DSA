// We have a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language. Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
// Sample Input 1 - N = 3, K = 3, dict = {"caa","aaa","aab"}
// Sample Output 1 - 1
// Sample Input 2 - N = 5, K = 4, dict = {"baa","abcd","abca","cab","cad"}
// Sample Output 2 - 1

import java.util.*;

public class AlienDictionary {
    public String alienOrder(int N, int K, String[] dict) {
        // Step 1 - Initialize graph structures
        Map<Character, List<Character>> graph = new HashMap<>(); // We use a graph (implemented as an adjacency list) to represent the order constraints between characters. Each key is a character, and its value is a list of characters that should come after it in the alien language.

        Map<Character, Integer> inDegree = new HashMap<>(); // The inDegree map tracks the number of incoming edges (dependencies) for each character. A character with an inDegree of 0 means there are no prerequisites for it, so it can appear first in the order.
        
        // Initialize inDegree for all characters
        for (String word : dict) {
            // This loop goes through every word in the dictionary and every character in each word.
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>()); // It ensures every character appears in the graph (even if it has no outgoing edges).
                inDegree.put(c, 0); // It sets the initial inDegree for each character to 0 because we haven’t yet identified any dependencies.
            }
        }
        
        // Step 2 - Build the graph
        for (int i = 1; i < dict.length; i++) {
            String word1 = dict[i - 1];
            String word2 = dict[i];
            int len = Math.min(word1.length(), word2.length());
            
            for (int j = 0; j < len; j++) {
                char parent = word1.charAt(j);
                char child = word2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    break;
                }
            }
        }
        
        // Step 3 - Perform topological sort using Kahn's algorithm
        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);
            
            for (char neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Step 4 - Check if all characters are in the result
        if (result.length() != inDegree.size()) {
            return ""; // If not all characters were included, return empty string
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        
        int N1 = 3, K1 = 3;
        String[] dict1 = {"caa","aaa","aab"};
        System.out.println(alienDictionary.alienOrder(N1, K1, dict1)); 
        
        int N2 = 5, K2 = 4;
        String[] dict2 = {"baa","abcd","abca","cab","cad"};
        System.out.println(alienDictionary.alienOrder(N2, K2, dict2)); 
    }
}

/*
    Example 1 -
        Input - N = 3, K = 3, dict = {"caa", "aaa", "aab"}

        Step-by-Step Execution -

            Graph Initialization -
                Process "caa" - Add 'c', 'a' (note: 'a' added only once despite appearing twice).
                Process "aaa" - 'a' already exists.
                Process "aab" - Add 'b' (new character).
                Graph - {c - [], a - [], b - []}
                inDegree - {c - 0, a - 0, b - 0}

            Building the Graph -
                Compare "caa" and "aaa" -
                At index 0 - 'c' vs. 'a' → They differ.
                Add edge - c -> a
                Update - inDegree of 'a' becomes 1.
                Break out of the loop.
                Compare "aaa" and "aab" -
                    Index 0 - 'a' vs. 'a' (same).
                    Index 1 - 'a' vs. 'a' (same).
                    Index 2 - 'a' vs. 'b' → They differ.
                Add edge - a -> b
                Update - inDegree of 'b' becomes 1.
                Break out of the loop.
                Graph Now -
                { c - [a], a - [b], b - [] }
                inDegree Now -
                { c - 0, a - 1, b - 1 }

            Topological Sort -
                Queue Initialization -
                    Add characters with inDegree 0 → only 'c' qualifies.
                Queue - ['c']
                Processing Queue -
                    Iteration 1 -
                        Dequeue 'c' → Append to result - "c".
                        For neighbor of 'c' → 'a' -
                        Decrease inDegree of 'a' from 1 to 0 → Add 'a' to queue.
                        Queue - ['a']
                    Iteration 2 -
                        Dequeue 'a' → Append to result - "ca".
                        For neighbor of 'a' → 'b' -
                        Decrease inDegree of 'b' from 1 to 0 → Add 'b' to queue.
                        Queue - ['b']
                    Iteration 3 -
                        Dequeue 'b' → Append to result - "cab".
                        'b' has no neighbors.
                        Queue - []
                        Final Result - "cab"
                    Validation -
                        The result length 3 equals the number of unique characters 3.
                        → Return "cab".

    Example 2 -
    Input - N = 5, K = 4, dict = {"baa", "abcd", "abca", "cab", "cad"}
    
    Step-by-Step Execution -

        Graph Initialization - 
            Process "baa" -
            Add 'b', 'a'.
            Process "abcd" -
            Add 'a' (exists), 'b' (exists), 'c', 'd'.
            Process "abca", "cab", "cad" -
            All characters already exist.
            Graph -
            { b - [], a - [], c - [], d - [] }
            inDegree -
            { b - 0, a - 0, c - 0, d - 0 }

        Building the Graph -
            Compare "baa" and "abcd":
            Index 0 - 'b' vs. 'a' → Differ.
            Add edge - b -> a
            Update - inDegree of 'a' becomes 1.
            Break.
            Compare "abcd" and "abca" -
            Indices 0, 1, 2 - 'a', 'b', 'c' are the same.
            Index 3 - 'd' vs. 'a' → Differ.
            Add edge - d -> a
            Update - inDegree of 'a' becomes 2.
            Break.
            Compare "abca" and "cab":
            Index 0 - 'a' vs. 'c' → Differ.
            Add edge - a -> c
            Update - inDegree of 'c' becomes 1.
            Break.
            Compare "cab" and "cad" -
            Indices 0 and 1 - 'c' and 'a' are the same.
            Index 2 - 'b' vs. 'd' → Differ.
            Add edge - b -> d
            Update - inDegree of 'd' becomes 1.
            Break.
            Graph Now -
            b - [a, d]
            a - [c]
            d - [a]
            c - []
            inDegree Now -
            b - 0, a - 2 (from edges b -> a and d -> a),
            c - 1 (from edge a -> c), d - 1 (from edge b -> d).

        Topological Sort -
            Queue Initialization -
            Characters with inDegree 0 → 'b'.
            Queue - ['b']
            Processing Queue -
                Iteration 1 -
                    Dequeue 'b' → Append to result - "b".
                    For neighbor 'a' -
                    Decrease inDegree from 2 to 1.
                    For neighbor 'd' -
                    Decrease inDegree from 1 to 0 → Add 'd' to queue.
                    Queue - ['d']
                Iteration 2 -
                    Dequeue 'd' → Append to result - "bd".
                    For neighbor 'a' -
                    Decrease inDegree from 1 to 0 → Add 'a' to queue.
                    Queue - ['a']
                Iteration 3 -
                    Dequeue 'a' → Append to result - "bda".
                    For neighbor 'c' -
                    Decrease inDegree from 1 to 0 → Add 'c' to queue.
                    Queue - ['c']
                Iteration 4 -
                    Dequeue 'c' → Append to result - "bdac".
                    'c' has no neighbors.
                    Queue - []
                    Final Result - "bdac"
                Validation -
                    The result length 4 equals the number of unique characters 4.
                    → Return "bdac".
*/