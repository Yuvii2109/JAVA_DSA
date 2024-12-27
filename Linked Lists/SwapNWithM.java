public class SwapNWithM {
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

    // Gyaan - toh bhai yahan par hume badalna toh sirf 2 nodes ko hai but
    // iska effect 6 nodes par pdega ab vo konse ?... suppose hume swap krne hain
    // 2nd node or 3rd node toh, usse 2nd or 3rd node toh affect honge hi.. saath main
    // 2nd node ka previous or next along with 3rd node ka previous or first bhi affect hoga
    // toh pehle toh hum validation krdenge saari jo bhi required hain 
    public void swapNWithM(int n, int m) {
        if (n == m) return; // No need to swap if indices are the same
        if (n < 0 || m < 0 || n >= size || m >= size) return; // Index validation

        Node prevN = null, prevM = null, currN = head, currM = head;

        // Find the nth node and its previous node
        for (int i = 0; i < n; i++) {
            prevN = currN;
            currN = currN.next;
        }

        // Find the mth node and its previous node
        for (int i = 0; i < m; i++) {
            prevM = currM;
            currM = currM.next;
        }

        // If either node is null, swapping is not possible
        if (currN == null || currM == null) return;

        // Update previous nodes to point to the other node
        if (prevN != null) {
            prevN.next = currM;
        } else {
            head = currM; // Update head if n is 0
        }

        if (prevM != null) {
            prevM.next = currN;
        } else {
            head = currN; // Update head if m is 0
        }

        // Swap the next pointers of the current nodes
        Node temp = currN.next;
        currN.next = currM.next;
        currM.next = temp;
    }

    public void printLL() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.print("null\n");
            System.out.println("Size of the LL is - " + size);
        }
    }

    public static void main(String args[]) {
        SwapNWithM LL = new SwapNWithM();
        LL.add(1);
        LL.add(2);
        LL.add(3);
        LL.add(4);
        LL.add(5);
        LL.add(6);
        LL.printLL();
        LL.swapNWithM(2, 3);
        LL.printLL();
    }
}