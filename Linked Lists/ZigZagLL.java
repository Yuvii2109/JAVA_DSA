public class ZigZagLL {
    // How does a zig zag linked list look like let's see -
    // normal - 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
    // zigzag - 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null
    // basically pehle ka aakhri, doosre ka aakhri se ek pehle 
    // wale ke saath and so on...
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
    public void zigZag(){
        if(head == null || head.next == null){
            return;
        }

        // Finding mid - 
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // Reversal of the second half -
        Node current = mid.next;
        mid.next = null; // breaking the loop 
        Node previous = null;
        Node next;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        Node leftHalfHead = head;
        Node rightHalfHalf = previous;
        Node nextLeft, nextRight;

        // Alternate merging / ZigZag merging -
        while(leftHalfHead != null && rightHalfHalf != null){
            nextLeft = leftHalfHead.next;
            leftHalfHead.next = rightHalfHalf;
            nextRight = rightHalfHalf.next;
            rightHalfHalf.next = nextLeft;
            leftHalfHead = nextLeft;
            rightHalfHalf = nextRight;
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
        ZigZagLL LL = new ZigZagLL();
        LL.head = new Node(1);
        LL.head.next = new Node(2);
        LL.head.next.next = new Node(3);
        LL.head.next.next.next = new Node(4);
        LL.head.next.next.next.next = new Node(5);
        LL.head.next.next.next.next.next = new Node(6);
        LL.printLL();
        LL.zigZag();
        LL.printLL();
    }
}