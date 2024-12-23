public class IterativeSearch {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static int size;
    public static Node head;
    public static Node tail;

    public int Search(int val){
        if(head == null){
            return 0;
        }else{
            Node current = head;
            int i = 0;
            while(current != null){
                if(current.data == val){
                    return i;
                }
                i++;
                current = current.next;
            }
            return -1;
        }
    }
    public void printLL(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " -> ");
                size++;
                temp = temp.next;
            }
            System.out.print("null\n" + size + " is the size of the LL");
        }
    }
    public static void main(String args[]){
        IterativeSearch LL = new IterativeSearch();
        LL.head = new Node(1);
        LL.head.next = new Node(2);
        LL.head.next.next = new Node(3);
        LL.head.next.next.next = new Node(4);
        LL.head.next.next.next.next = new Node(5);
        LL.printLL();
        if(LL.Search(3) == 0){
            System.out.println("\nList Empty");
        }else if(LL.Search(3) == -1){
            System.out.println("\nElement not found");
        }else{
            System.out.println("\nElement found at node number - " + (LL.Search(3)+1));
        }
    }
}