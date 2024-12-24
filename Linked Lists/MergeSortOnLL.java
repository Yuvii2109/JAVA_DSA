public class MergeSortOnLL {
    // Middle node iss code main hum 1st half ka last node consider krenge
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
    public Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1); // dummy node allot krdia
        Node temp = mergedLL;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next; // Kyunki iske head main dummy node ka -1 stored hai
    }
    public Node getMid(Node head){
        Node slow = head; 
        Node fast = head.next; 
        // Ab yu ki yeh kyu kiya?
        // This is done so as to achieve the last node of the 1st half as the mid
        // Agar hum fast ko bhi head bna denge toh hmare 2nd half ka first node mid
        // ho jayega jo ki filhaal hmari approach nahi hai no particular reason but m 
        // more confortable with this approach...
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Slow would turn out to be the mid
    }
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        // Determining mid -
        Node mid = getMid(head);

        // Performing Merge Sort on the left and right half -
        Node rightHead = mid.next;
        mid.next = null;
        Node leftHead = head;
        Node newLeft = mergeSort(leftHead);
        Node newRight = mergeSort(rightHead);

        // Merge -
        return merge(newLeft, newRight);
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
        MergeSortOnLL LL = new MergeSortOnLL();
        LL.head = new Node(10);
        LL.head.next = new Node(5);
        LL.head.next.next = new Node(20);
        LL.head.next.next.next = new Node(3);
        LL.head.next.next.next.next = new Node(1);
        LL.head.next.next.next.next.next = new Node(9);
        LL.printLL();
        LL.head = LL.mergeSort(LL.head);
        LL.printLL();
    }
}