public class CycleOrLoopRemoval {
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
    public static boolean isCyclic(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if(slow == fast){
                return true; // Cycle is forming
            }
        }
        return false;
    }
    public static void removeCycle(){
        if(head == null){
            return;
        }else{
            // Detect if cycle or not
            Node slow = head;
            Node fast = head;
            boolean cycle = false;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast == slow){
                    cycle = true;
                    break;
                }
            }
            if(cycle == false){
                System.out.println("No cycle");
                return;
            }

            // Find the starting point of the cycle 
            slow = head;
            Node prev = null;
            while(slow != fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }

            // Remove the cycle
            prev.next = null;
        }
    }
    public static void main(String args[]){
        // Create a linked list with a cycle
        head = new Node(1); 
        head.next = new Node(2); 
        head.next.next = new Node(3); 
        head.next.next.next = new Node(4); 
        head.next.next.next.next = head.next; 
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }
}