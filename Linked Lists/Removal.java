public class Removal {
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

    // Method - 1
    public void removeFromBeginning(){
        if(head == null){
            System.out.println("List is empty");
        }else if(head.next == null){
            head = tail = null;
        }else{
            head = head.next;
        }
    }

    // Method - 2
    public void removeFromEnd(){
        if(head == null){
            System.out.println("List is empty");
        }else if(head.next == null){
            head = tail = null;
        }else{
            Node temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
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
    public static void main(String args[]){
        Removal LL = new Removal();
        LL.head = new Node(1);
        LL.head.next = new Node(2);
        LL.head.next.next = new Node(3);
        LL.head.next.next.next = new Node(4);
        LL.head.next.next.next.next = new Node(5);

        // It is important to set the tail to the last node -
        LL.tail = LL.head;
        while(LL.tail.next != null){
            LL.tail = LL.tail.next;
        }
        // Alternative is to make us of the size of the linked list to determine the tail
        // kyunki agar tail set nahi karenge toh removal from end nahi ho payega

        LL.printLL();
        LL.removeFromBeginning();
        LL.printLL();
        LL.removeFromEnd();
        LL.printLL();
    }
}