public class UsingLinkedLists {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class Queue{
        public static Node head = null;
        public static Node tail = null;
        
        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        // Addition -
        public static void enqueue(int data){
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            }
        }
        // Time Complexity - O(1)

        // Removal -
        public static int dequeue(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }else{
                int front = head.data;
                if (head == tail) {
                    head = tail = null;
                }else{
                    head = head.next;
                }
                return front;
            }
        }
        // Time Complexity - O(1)

        // Peek -
        public static int peek(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }else{
                return head.data;
            }
        }
        // Time Complexity - O(1)
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.dequeue();
        }
        q.dequeue();
        q.peek();
    }
}