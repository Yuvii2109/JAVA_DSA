public class PalindromeLL {
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

    // Slow-Fast Approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow; // slow is the mid-node
    }
    public boolean checkPallindrome(){
        if(head == null || head.next == null){
            return true;
        }

        // Find mid -
        Node mid = findMid(head);

        // Reverse Second half
        Node previous = null;
        Node current = mid;
        Node next;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        Node rightHalfHead = previous; // Right half ka head
        Node leftHalfHead = head; // Left half ka head

        // Check left half and right half
        while(rightHalfHead != null){
            if(leftHalfHead.data != rightHalfHead.data){
                return false;
            }
            leftHalfHead = leftHalfHead.next;
            rightHalfHead = rightHalfHead.next;
        }
        return true;
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
        PalindromeLL LL = new PalindromeLL();
        LL.head = new Node(1);
        LL.head.next = new Node(2);
        LL.head.next.next = new Node(3);
        LL.head.next.next.next = new Node(2);
        LL.head.next.next.next.next = new Node(1);
        LL.printLL();
        if(LL.checkPallindrome()){
            System.out.println("List is a palindrome");
        }else{
            System.out.println("List is not a palindrome");
        }
    }
}