public class Reversal {

    // Yaar iska mantra hai jo yaad krlo... agr smjh skte toh or bdiya baat hai
    // Toh basically reverse krne ke liye humne bnane pdenge 3 pointers - 
    // previous, current, next. Proceeding as follows -
    // Previous pointer ko chodh de ek second ke liye...
    // Current ko head bna do and next = current.next...
    // current.next = previous
    // previous = current
    // current = next
    // And all set!!!

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public void reverse(){
        Node previous = null;
        Node current = tail = head;
        Node next;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
    public void printLL(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.print("null\n");
        }
    }
    public static void main(String[] args) {
        Reversal LL = new Reversal();
        LL.head = new Node(1);
        LL.head.next = new Node(2);
        LL.head.next.next = new Node(3);
        LL.head.next.next.next = new Node(4);
        LL.head.next.next.next.next = new Node(5);
        LL.printLL();
        LL.reverse();
        LL.printLL();
    }
}