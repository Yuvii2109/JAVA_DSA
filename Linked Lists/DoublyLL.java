public class DoublyLL {
    public static class Node{
        int data;
        Node next;
        Node previous;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
    public static Node head;
    public static Node tail;
    public int size = 0;

    // Addition -
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }
    public void addEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }else{
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void addSpecific(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            addFirst(data);
        } else if (position == size) {
            addEnd(data);
        } else {
            Node newNode = new Node(data);
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next; // Link newNode to the next node
            temp.next.previous = newNode; // Update the previous pointer of the next node
            temp.next = newNode; // Link temp to newNode
            newNode.previous = temp; // Link newNode back to temp
            size++;
        }
    }

    // Removal -
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next; // Shifts the head to the next node
        if (head == null) {
            tail = null;
        } else {
            head.previous = null; // Breaks the link to the previous head
        }
        size--;
    }
    public void removeEnd() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
    }
    public void removeSpecific(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position < 0 || position >= size) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            removeFirst();
        } else if (position == size - 1) {
            removeEnd();
        } else {
            Node temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.next;
            }
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
            size--;
        }
    }

    // Printing 
    public void printLL(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            System.out.print("null <-> ");
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.print("null\n");
        }
        System.out.println("Size of Doubly Linked list is - " + size + "\n");
    }

    public static void main(String args[]){
        DoublyLL DLL = new DoublyLL();
        DLL.printLL();
        DLL.addFirst(1);
        DLL.addEnd(2);
        DLL.addEnd(3);
        DLL.addEnd(5);
        DLL.addFirst(0);
        DLL.addSpecific(4, 4);
        DLL.printLL();
        DLL.removeFirst();
        DLL.printLL();
        DLL.removeEnd();
        DLL.printLL();
        DLL.removeSpecific(3);
        DLL.printLL();
    }
}