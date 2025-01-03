import java.util.*;

public class ReverseFirstKElements {
    public static void reverseFirstKElements(Queue<Integer> q, int k){
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < k; i++){
            stack.push(q.poll());
        }
        while(!q.isEmpty()){
            queue.add(q.poll());
        }
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
        while(!queue.isEmpty()){
            q.add(queue.poll());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        System.out.println("Queue before reversal - ");
        System.out.println(q);
        reverseFirstKElements(q, 5);
        System.out.println("Queue after reversal - ");
        System.out.println(q);
    }
}

// Linear time complexity - O(n)