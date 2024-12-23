public class LoopOrCycleDetection {
    // Floyd's Cycle Finding Algorithm
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
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if(slow == fast){
                return true; // Cycle is forming
            }
        }
        return false; // Cycle is not forming
    }
    public static void printLL(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            // Idhr null bhi print krwata but kyuki yahan cycle form ho rahi 
            // hai isliye loop form ho rha hoga isliye null hoga hi ni kuch
            // toh agar print krwa di... toh infinite loop form ho jayega
            // or print hota rahega bas isliye apan print nahi krwayege
        }
    }
    public static void main(String args[]){
        // Create a linked list with a cycle
        head = new Node(1); // 1 -> null
        head.next = new Node(2); // 1 -> 2 -> null
        head.next.next = new Node(3); // 1 -> 2 -> 3 -> null
        head.next.next.next = new Node(4); // 1 -> 2 -> 3 -> 4 -> null
        head.next.next.next.next = head.next; 
        // 1 -> 2 -> 3 -> 4
        //      ↑         ↓
        //       <-  <-  <-
        System.out.println("Is this linked list cyclic? \n" + isCycle());
    }
}