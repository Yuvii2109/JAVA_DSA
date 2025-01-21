// Minimum time required to fill given N slots
// We have an integer N which denotes the number of slots, and an 
// array arr[] consisting of K integers in the range [1, N] repreand. 
// Each element of the array are in the range [1, N] which represents 
// the indices of the filled slots. At each unit of time, the index 
// with filled slot fills the adjacent empty slots. The task is to find 
// the minimum time taken to fill all the N slots.
// Sample Input 1 - N = 5, K = 5, arr[] = {1, 2, 3, 4, 5}
// Sample Output 1 - 1
// Sample Input 2 - N = 6, K = 2, arr[] = {2, 6}
// Sample Output 2 - 2

import java.util.PriorityQueue;

public class MinTimeToFillNSlots {
    static class Slot implements Comparable<Slot> {
        int index, time;

        Slot(int index, int time) {
            this.index = index;
            this.time = time;
        }

        // Override the compareTo method for natural ordering by time
        @Override
        public int compareTo(Slot other) {
            return this.time - other.time; 
            // Ascending order based on time
        }
    }

    public static void minTime(int[] arr, int N, int K) {
        // Priority Queue to process slots in order of time
        PriorityQueue<Slot> pq = new PriorityQueue<>();

        // Visited array to track filled slots
        boolean[] visited = new boolean[N + 1];

        // Initialize the queue with the initially filled slots
        for (int slot : arr) {
            pq.add(new Slot(slot, 0));
            visited[slot] = true;
        }

        int maxTime = 0;

        // Process slots
        while (!pq.isEmpty()) {
            Slot current = pq.poll();
            int index = current.index;
            int time = current.time;

            // Update maximum time
            maxTime = Math.max(maxTime, time);

            // Check left and right neighbors
            if (index - 1 >= 1 && !visited[index - 1]) {
                pq.add(new Slot(index - 1, time + 1));
                visited[index - 1] = true;
            }
            if (index + 1 <= N && !visited[index + 1]) {
                pq.add(new Slot(index + 1, time + 1));
                visited[index + 1] = true;
            }
        }

        // Output the result
        System.out.println(maxTime);
    }

    public static void main(String[] args) {
        int N = 6;
        int arr[] = { 2, 6 };
        int K = arr.length;
        minTime(arr, N, K);
    }
}

// Time complexity - O(NlogN)
// Space complexity - O(N)