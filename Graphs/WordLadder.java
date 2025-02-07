// We have a dictionary, and two words ‘start’ and ‘target’ (both of same length). Find length of the smallest chain from ‘start’ to ‘target’ if it exists, such that adjacent words in the chain only differ by one character and each word in the chain is a valid word i.e., it exists in the dictionary. It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.
// Input - Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}, start = TOON, target = PLEA
// Output - 7
// Explanation - TOON – POON – POIN – POIE – PLIE – PLEE – PLEA

import java.util.*;

public class WordLadder {
    // Function to find the shortest chain length
    public static int shortestChainLength(String start, String target, Set<String> dictionary) {
        // If the target word is not in the dictionary, return -1 (not possible)
        if (!dictionary.contains(target)) return -1;
        
        // Queue for BFS - stores (currentWord, currentChainLength)
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 1));

        // Set to keep track of visited words
        Set<String> visited = new HashSet<>();
        visited.add(start);

        // Perform BFS
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            int length = current.length;

            // If we reach the target word, return the chain length
            if (word.equals(target)) {
                return length;
            }

            // Try changing one letter at a time
            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray();
                
                for (char c = 'A'; c <= 'Z'; c++) { // Replace with all possible letters
                    if (wordArray[i] == c) continue; // Skip same character
                    
                    wordArray[i] = c; // Modify character
                    String newWord = new String(wordArray);
                    
                    // If the new word is in the dictionary and not visited
                    if (dictionary.contains(newWord) && !visited.contains(newWord)) {
                        queue.add(new Pair(newWord, length + 1));
                        visited.add(newWord);
                    }
                }
            }
            // The code iterates over each character position in the current word. For each position, it converts the word into a character array (wordArray) to allow modifications. Then, for every letter from 'A' to 'Z', it - Skips the letter if it’s the same as the current character. Otherwise, replaces the current character with the new letter. Constructs a new word (newWord) from the modified character array. If newWord is in the dictionary and has not been visited, it is added to the queue with an incremented chain length, and it is marked as visited.
        }
        
        // No transformation found
        return -1;
    }

    // Helper class to store words and their transformation length
    static class Pair {
        String word;
        int length;

        Pair(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(
            "POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"
        ));

        String start = "TOON";
        String target = "PLEA";

        int result = shortestChainLength(start, target, dictionary);
        System.out.println("Length of the shortest transformation chain - " + result);
    }
}

// Time Complexity - O(N*L*26), where -
// N = size of the dictionary.
// L = length of each word.
// 26 = possible letters for modification.