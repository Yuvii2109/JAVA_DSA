public class CreatingANode{
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
    public void addAtBeginning(int data){ // O(1) - constant time complexity
        // Create a new node
        Node newNode = new Node(data);
        // If the list is empty, set the new node as both head and tail
        if (head == null) {
            head = tail = newNode;
            return;
        }else{
            // Otherwise, set the new node as the head and update the head's next pointer
            newNode.next = head; // Linking
            head = newNode; 
        }
    }

    // Method - 2
    public void addAtEnd(int data){ // O(1) - constant time complexity
        // Create a new node
        Node newNode = new Node(data);
        // If the list is empty, set the new node as both head and tail
        if (head == null) {
            head = tail = newNode;
            return;
        }else{
            // Otherwise, update the tail's next pointer to point to the new node
            tail.next = newNode; // Linking
            tail = newNode; // Update the tail
        }
    }

    public void printLL(){
        System.out.println();
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.print("null");
            System.out.println("\n");
        }
    }
    public static void main(String args[]){
        CreatingANode LL = new CreatingANode();
        // LL.head = new Node(1);
        // LL.head.next = new Node(2);
        // Aise kr skte hain par hm krenge nahi rather hm iske methods
        // main class se pehle hi
        LL.printLL();
        LL.addAtBeginning(2);
        LL.printLL();
        LL.addAtBeginning(1);
        LL.printLL();
        LL.addAtEnd(3);
        LL.printLL();
        LL.addAtEnd(4);
        LL.printLL();
    }
}