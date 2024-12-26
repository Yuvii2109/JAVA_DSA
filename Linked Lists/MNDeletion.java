public class MNDeletion {
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
    public int size = 0;
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Method to delete 'n' nodes after skipping 'm' nodes
    public void deleteNAfterM(int n, int m) {
        if (head == null || n <= 0) {
            return; // No deletion if the list is empty or n is invalid
        }

        Node temp = head;

        // Skip the first 'm' nodes
        for (int i = 1; i < m && temp != null; i++) {
            temp = temp.next;
        }

        // If we've reached the end of the list, nothing to delete
        if (temp == null || temp.next == null) {
            System.out.println("No elements were deleted");
            return;
        }

        // Delete 'n' nodes after the 'm' nodes
        Node current = temp.next;
        for (int j = 0; j < n && current != null; j++) {
            current = current.next;
            size--;
        }

        // Connect the 'm' nodes to the rest of the list
        temp.next = current;
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
            System.out.println("Size of the LL is - " + size); 
        }
    }
    public static void main(String[] args) {
        MNDeletion LL = new MNDeletion();
        LL.add(1);
        LL.add(2);
        LL.add(3);
        LL.add(4);
        LL.add(5);
        LL.add(6);
        LL.add(7);
        LL.add(8);
        LL.add(9);
        LL.printLL();
        LL.deleteNAfterM(2, 3);
        LL.printLL();
    }
}

// Time complexity = O(n+m)