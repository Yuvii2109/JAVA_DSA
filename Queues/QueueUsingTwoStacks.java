import java.util.*;

public class QueueUsingTwoStacks {
    public static class Queue{
        public static Stack<Integer> stack1 = new Stack<Integer>();
        public static Stack<Integer> stack2 = new Stack<Integer>();

        public static boolean isEmpty(Stack<Integer> stack){
            return stack.isEmpty();
        }
        
        // Method - 1 -> pushing with O(n) and the rest with O(1)
        // Method - 2 -> popping with O(n) and the rest with O(1)

        // Addition - (Method - 1)
        public static void enqueue(int data){
            while(!isEmpty(stack1)){
                stack2.push(stack1.pop());
            }
            stack1.push(data);
            while(!isEmpty(stack2)){
                stack1.push(stack2.pop());
            }
        }
        // Time complexity - O(n)

        // Addition - (Method - 2)
        public static void enqueueMethod2(int data){
            stack1.push(data);
        }
        // Time complexity - O(1)

        // Removal - (Method - 1)
        public static int dequeue(){
            if(isEmpty(stack1)){
                System.out.println("Queue is empty");
                return -1;
            }else{
                int front = stack1.pop();
                return front;
            }
        }
        // Time complexity - O(1)

        // Removal - (Method - 2)
        public static int dequeueMethod2(){
            if(isEmpty(stack2)){
                while(!isEmpty(stack1)){
                    stack2.push(stack1.pop());
                }
            }
            if(isEmpty(stack2)){
                System.out.println("Queue is empty");
                return -1;
            }
            return stack2.pop();
        }
        // Time complexity - O(n)

        // Peek -
        public static int peek(){
            if(isEmpty(stack1)){
                System.out.println("Queue is empty");
                return -1;
            }else{
                return stack1.peek();
            }
        }
        // Time complexity - O(1)
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("Dequeued element - " + q.dequeue());
        System.out.println("Dequeued element - " + q.dequeue());
        System.out.println("Dequeued element - " + q.dequeue());
        System.out.println(q.peek());
    }
}