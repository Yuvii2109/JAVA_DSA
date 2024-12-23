public class RemoveNthFromEnd {
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
    public void deleteNthFromEnd(int n){
        if (head == null) {
            return;
        }else{
            int size = 0;
            Node temp = head;
            while(temp != null){
                temp = temp.next;
                size++;
            }
            if(n > size){
                System.out.println("n is larger than the size of the list");
            }else if(n == size){
                head = head.next;
                return;
            }else{
                int i = 1;
                Node prev = head;
                while(i < (size - n)){
                    // nth from end is (size-n+1)th from beginning
                    prev = prev.next;
                    i++;
                }
                prev.next = prev.next.next;
                return;
            }
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
        RemoveNthFromEnd LL = new RemoveNthFromEnd();
        LL.head = new Node(1);
        LL.head.next = new Node(2);
        LL.head.next.next = new Node(3);
        LL.head.next.next.next = new Node(4);
        LL.head.next.next.next.next = new Node(5);
        LL.printLL();
        LL.deleteNthFromEnd(2);
        LL.printLL();
        LL.deleteNthFromEnd(4);
        LL.printLL();
        LL.deleteNthFromEnd(8);
    }
}