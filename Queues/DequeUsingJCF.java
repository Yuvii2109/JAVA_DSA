// DEQUE - Double Ended Queue
// A deque is a data structure that allows elements 
// to be added or removed from both ends. Seedhi bhasha main
// FIFO or LIFO dono upyogitayen hain isme...

import java.util.*;

public class DequeUsingJCF {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        System.out.println("First element - " + deque.getFirst());
        System.out.println("Last element - " + deque.getLast());
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
    }
}