import java.util.PriorityQueue;

public class PriorityQueuesInJCF{
    public static void main(String args[]){
        // Create a priority queue -
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // Add elements to the priority queue - O(logn)
        pq.add(10);
        pq.add(7);
        pq.add(3);
        pq.add(5);
        pq.add(1);

        while (!pq.isEmpty()) {
            // Peek elements - O(1)
            System.out.println(pq.peek());
            // Remove elements - O(logn)
            pq.remove();
        }
    }
}