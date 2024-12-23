public class SpecificPosition {
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

    public void insertAtSpecific(int data, int position){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            // Yaar agar node hi nahi hai toh first position par hi lgayega na 
        }else{
            if(position-1 == 0){
                // Agar first position par lagana hai toh insertAtBeginning hi hogya 
                newNode.next = head;
                head = newNode;
            }else{
                // Ab aate hain mudde par... toh dekho data toh assign kar hi diya hai
                // Jis position par lgana hai vahan tak traverse krne ke liye
                // head ko temp pointer allot krdiya
                Node temp = head;
                int i = 0;
                while(i != position - 2){
                    // Suppose hume 3rd position par lgana hai... par hum zero based indexing 
                    // use kr rhe hain toh hume basically 2nd index par lgana hai... uske liye
                    // humne pointer 0 se shuru kiya or proceed kaise kiya yeh dekho - 
                    // 1st iteration: temp = head
                    // ab first iteration ke baad ruk jayega or pehle temp head ka next ho jayega
                    // which is nothing but the second node
                    temp = temp.next;
                    i++;
                }
                // ab hmne kya kra ki second node ka next third hai...
                // uss third node ko hmne newNode ka next allot krdia...
                newNode.next = temp.next;
                // phir hmne newNode ko second node ka next bna diya... 
                temp.next = newNode;
                // toh hmara newNode third node ban chuka hai as per the requirement
            }
        }
    }
    public void printLL(){
        System.out.println();
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.print("null\n");
        }
    }
    public static void main(String args[]){
        SpecificPosition LL = new SpecificPosition();
        LL.head = new Node(1);
        LL.head.next = new Node(2);
        LL.head.next.next = new Node(4);
        LL.printLL();
        LL.insertAtSpecific(3, 3);
        LL.printLL();
    }
}