public class CircularQueueUsingArrays {
    public static class Queue{
        public static int[] arr;
        public static int size;
        public static int front;
        public static int rear;

        public Queue(int n){
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        public static boolean isEmpty(){
            return front == -1 && rear == -1;
        }

        public static boolean isFull(){
            return (rear + 1) % size == front;
        }

        // Addition -
        public static void enqueue(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }else{
                if(front == -1){
                    front = 0;
                    rear = 0;
                    arr[rear] = data;
                }else{
                    rear = (rear + 1) % size;
                    arr[rear] = data;
                }
            }
        }
        // Time complexity - O(1)

        // Removal -
        public static int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }else{
                int temp = arr[front];
                if(front == rear){
                    front = -1;
                    rear = -1;
                    return temp;
                }else{
                    front = (front + 1) % size;
                    return temp;
                }
            }
        }
        // Time complexity - O(1)

        // Peek -
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }else{
                return arr[front];
            }
        }
        // Time complexity - O(1)
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.dequeue();
        }
        q.dequeue();
        q.peek();
    }
}