import java.util.*;

public class StackUsingDeque {
    public static class Stack{
        Deque<Integer> deque = new LinkedList<>();
        public void push(int item) {
            deque.addFirst(item);
        }
        public int pop() {
            if (deque.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }else{
                return deque.removeFirst();
            }
        }
        public int peek(){
            if (deque.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }else{
                return deque.peekFirst();
            }
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}