public class OddEvenLL {
    public static class Node {
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

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void oddEvenOrder() {
        if (head == null || head.next == null) {
            return; // No reordering needed
        }

        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;

        Node temp = head;

        while (temp != null) {
            if (temp.data % 2 == 0) {
                // Even node
                if (evenHead == null) {
                    evenHead = evenTail = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = temp;
                }
            } else {
                // Odd node
                if (oddHead == null) {
                    oddHead = oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = temp;
                }
            }
            temp = temp.next;
        }

        // Combine odd and even lists
        if (evenTail != null) {
            evenTail.next = oddHead;
            head = evenHead; // Update head to the start of the even list
        } else {
            head = oddHead; // If there are no even nodes, the odd list becomes the main list
        }

        if (oddTail != null) {
            oddTail.next = null; // Ensure the last node of the odd list points to null
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        OddEvenLL list = new OddEvenLL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println("Original List -");
        list.printList();
        list.oddEvenOrder();
        System.out.println("Reordered List (Even followed by Odd) - ");
        list.printList();
    }
}

// Time Complexity = O(n)