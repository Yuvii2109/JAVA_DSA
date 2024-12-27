public class UsingLinkedLists {
    public static class Node{
        int data; 
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static class Stack{
        public static boolean isEmpty(){
            return head == null;
        }
        
        // push
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
            }else{
                newNode.next = head;
                head = newNode;
            }
        }
        // pop
        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }else{
                int top = head.data;
                head = head.next;
                return top;
            }
        }
        // peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }else{
                return head.data;
            }
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.isEmpty());
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}