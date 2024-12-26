public class IntersectionNode {
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
    public Node getIntersectingNode(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }else{
            Node temp1 = head1;
            Node temp2 = head2;

            // Two-pointer technique
            while (temp1 != temp2) {
                // Move to the next node, or reset to the other list's head if null
                temp1 = (temp1 == null) ? head2 : temp1.next;
                temp2 = (temp2 == null) ? head1 : temp2.next;
            }
            // while (temp1 != temp2) {
            //     if (temp1 == null) {
            //         temp1 = head2; -> "head1 exist nahi krta toh head2 return ho jayega"
            //     } else {
            //         temp1 = temp1.next;
            //     }
            //     if (temp2 == null) {
            //         temp2 = head1; -> "head2 exist nahi krta toh head1 return ho jayega"
            //     } else {
            //         temp2 = temp2.next;
            //     }
            // }

            // Either the intersection node or null
            return temp1;
        }
    }
    public static void main(String args[]){
        IntersectionNode LL = new IntersectionNode();
        // Creating linked lists with an intersection
        Node head1 = new Node(1);
        Node head2 = new Node(4);

        head1.next = new Node(2);
        head2.next = new Node(5);

        head1.next.next = new Node(3);
        Node newNode = new Node(6);

        head1.next.next.next = newNode;
        head2.next.next = newNode;

        newNode.next = new Node(7);
        // 1 -> 2 -> 3 -> 6 -> 7 -> null
        //                ↑
        //      4 -> 5 -> ↑
        Node intersectionPoint = LL.getIntersectingNode(head1, head2);
        if(intersectionPoint == null){
            System.out.println("No intersection point");
        }else{
            System.out.println("Intersection point is - " + intersectionPoint.data);
        }
    }
}

// Time complexity - O(n+m) 

// Gandi Time complexity ka code bhi exist krta hai - 
// public Node getIntersectionNode(Node head1, Node head2){
//     while (head2 != null){
//         Node temp = head1;
//         while (temp != null) {
//             if (temp == head2) {
//                 return head2;
//             }
//             temp = temp.next;
//         }
//         head2 = head2.next;
//     }
//     return null;
// }
// Time complexity - O(n*m)