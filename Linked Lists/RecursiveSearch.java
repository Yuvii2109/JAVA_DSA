public class RecursiveSearch {
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
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int index = helper(head.next, key);
        if(index == -1){
            return -1;
        }
        return (index+1);
    }
    public int search(int key){
        return helper(head, key);
    }
    public void printLL(){
        if(head == null){
            System.out.println("Empty List");
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
        RecursiveSearch LL = new RecursiveSearch();
        LL.head = new Node(1);
        LL.head.next = new Node(2);
        LL.head.next.next = new Node(3);
        LL.head.next.next.next = new Node(4);
        LL.head.next.next.next.next = new Node(5);
        LL.printLL();
        if(LL.search(3) == -1){
            System.out.println("Element not found");
        }else if(LL.search(3) == 0){
            System.out.println("Element found in node number - " + 1);
        }else{
            System.out.println("Element found in node number - " + (LL.search(3)+1));
        }
    }
}