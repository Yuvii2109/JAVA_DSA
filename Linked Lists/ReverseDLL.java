public class ReverseDLL {
    public static class Node{
        int data;
        Node next;
        Node previous;
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
    public static Node head;
    public static Node tail;
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }
    public void reverse(){
        Node current = head;
        Node previous = null;
        Node next;
        while(current != null){
            next = current.next;
            current.next = previous;
            current.previous = next;
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
            System.out.print("null <-> ");
            while(temp != null){
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.print("null\n");
        }
    }
    public static void main(String[] args) {
        ReverseDLL DLL = new ReverseDLL();
        DLL.add(1);
        DLL.add(2);
        DLL.add(3);
        DLL.add(4);
        DLL.add(5);
        DLL.add(6);
        System.out.println("Original List - ");
        DLL.printLL();
        DLL.reverse();
        System.out.println("Reversed List - ");
        DLL.printLL();
    }
}