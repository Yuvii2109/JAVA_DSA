public class UsingArrays {
    public static class Queue{
        public static int arr[];
        public static int size;
        public static int rear;

        public Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // Check if the queue is empty
        public static boolean isEmpty(){
            return rear == -1;
        }

        // Add - 
        public static void add(int data){
            if(rear == size - 1){
                System.out.println("Queue is full");
                return;
            }else{
                rear++;
                arr[rear] = data; 
            }
        }
        // Time complexity - O(1)

        // Remove -
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }else{
                int front = arr[0];
                for(int i = 0; i < rear; i++){
                    arr[i] = arr[i + 1];
                }
                rear--;
                return front;
            }
        }
        // Time complexity - O(n)

        // Peek -
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }else{
                return arr[0];
            }
        }
        // Time complexity - O(1)
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        q.remove();
    }
}