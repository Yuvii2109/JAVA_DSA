import java.util.*;

public class StackUsingTwoQueues {
    public static class Stack {
        public static Queue<Integer> queue1 = new LinkedList<>();
        public static Queue<Integer> queue2 = new LinkedList<>();

        public static boolean isEmpty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }

        // Method - 1 -> popping and peeking with O(n) and pushing with O(1)
        // Method - 2 -> pushing with O(n) and the rest with O(1)

        // Addition - (Method - 1)
        public static void push(int data) {
            if (!queue1.isEmpty()) {
                queue1.add(data);
            } else {
                queue2.add(data);
            }
        }
        // Time complexity - O(1)

        // Removal - (Method - 1)
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            } else {
                int top = -1;
                if (!queue1.isEmpty()) {
                    while (!queue1.isEmpty()) {
                        top = queue1.poll();
                        if (queue1.isEmpty()) {
                            break;
                        }
                        queue2.add(top);
                    }
                } else {
                    while (!queue2.isEmpty()) {
                        top = queue2.poll();
                        if (queue2.isEmpty()) {
                            break;
                        }
                        queue1.add(top);
                    }
                }
                return top;
            }
        }
        // Time complexity - O(n)

        // Peek - (Method - 1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            } else {
                int top = -1;
                if (!queue1.isEmpty()) {
                    while (!queue1.isEmpty()) {
                        top = queue1.poll();
                        queue2.add(top);
                    }
                } else {
                    while (!queue2.isEmpty()) {
                        top = queue2.poll();
                        queue1.add(top);
                    }
                }
                return top;
            }
        }
        // Time complexity - O(n)

        // Method - 2

        // Addition - (Method - 2)
        public static void pushMethod2(int data) {
            if (!queue1.isEmpty()) {
                queue2.add(data);
                while (!queue1.isEmpty()) {
                    queue2.add(queue1.poll());
                }
            } else {
                queue1.add(data);
                while (!queue2.isEmpty()) {
                    queue1.add(queue2.poll());
                }
            }
        }
        // Time complexity - O(n)

        // Removal - (Method - 2)
        public static int popMethod2() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            if (!queue1.isEmpty()) {
                return queue1.poll();
            } else {
                return queue2.poll();
            }
        }
        // Time complexity - O(1)

        // Peek - (Method - 2)
        public static int peekMethod2() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            if (!queue1.isEmpty()) {
                return queue1.peek();
            } else {
                return queue2.peek();
            }
        }
        // Time complexity - O(1)
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        // Using Method 1
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Using Method 1 -");
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

        // Using Method 2
        s.pushMethod2(4);
        s.pushMethod2(5);
        s.pushMethod2(6);
        System.out.println("Using Method 2 -");
        while (!s.isEmpty()) {
            System.out.println(s.popMethod2());
        }
    }
}