import java.util.*;

public class QueueUsingDeque {
    public static class Queue{
        Deque<Integer> deque = new LinkedList<>();
        public void enqueue(int item) {
            deque.add(item);
        }
        public int dequeue(){
            if(deque.isEmpty()){
                throw new RuntimeException("Queue is empty");
            }else{
                return deque.removeFirst();
            }
        }
        public int peek(){
            if(!deque.isEmpty()){
                return deque.getFirst();
            }else{
                System.out.println("Queue is empty");
                return -1;
            }
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.peek());
        q.dequeue();
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}