public class Size {
    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    
    public void sizeOfLL(){
        if(head == null){
            System.out.println("Size of Linked List is - 0");
        }else{
            Node temp = head;
            while(temp != null){
                size++;
                temp = temp.next;
            }
            System.out.println("Size of the linked list is - " + size);
        }
    }
    public static void main(String args[]){
        Size LL = new Size();
        LL.head = new Node(1);
        LL.head.next = new Node(2);
        LL.head.next.next = new Node(3);
        LL.sizeOfLL();
    }
}