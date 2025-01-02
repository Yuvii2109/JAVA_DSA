import java.util.*;

public class QueueReversal {
    public static void reversal(Queue<Integer> q){
        Stack<Integer> stack = new Stack<Integer>();
        while(!q.isEmpty()){
            stack.push(q.poll());
        }
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println("Queue before Reversal - ");
        System.out.println(queue);
        reversal(queue);
        System.out.println("Queue after Reversal - ");
        System.out.println(queue);
    }
}