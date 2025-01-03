import java.util.*;

public class GenerateBinaryNumbers {

    // Method to generate binary numbers
    public static void generateBinaryNumbers(int n) {
        // Queue to store binary numbers
        Queue<String> queue = new LinkedList<>();

        // Enqueue the first binary number
        queue.add("1");

        // Generate binary numbers
        for (int i = 0; i < n; i++) {
            // Dequeue the front element
            String current = queue.poll();

            // Print the current binary number
            System.out.println(current);

            // Generate the next binary numbers and enqueue
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }

    public static void main(String[] args) {
        int n = 10; // Number of binary numbers to generate
        System.out.println("First " + n + " binary numbers -");
        generateBinaryNumbers(n);
    }
}