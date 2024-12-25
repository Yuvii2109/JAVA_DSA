public class CircularLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static Node head;
    public int size = 0;

    // Addition -
    public void add(int data){
        addAtEnd(data);
    }
    public void addAtBeginning(int data){
        if(head == null){
            head = new Node(data);
            head.next = head;
        }else{
            Node newNode = new Node(data);
            newNode.next = head;
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newNode;
            head = newNode;
        }
        size++;
    }
    public void addAtEnd(int data){
        if(head == null){
            head = new Node(data);
            head.next = head;
        }else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = new Node(data);
            temp.next.next = head;
        }
        size++;
    }
    public void addAtSpecific(int data, int index){
        if(head == null){
            head = new Node(data);
            head.next = head;
        }
        if(index < 0 || index > size-1){
            System.out.println("Invalid index");
        }else{
            if(index == 0){
                addAtBeginning(data);
            }else if(index == size){
                addAtEnd(data);
            }else{
                Node temp = head;
                for(int i = 0; i < index-1; i++){
                    temp = temp.next;
                }
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        size++;
    }

    // Removal -
    public void removeAtBeginning(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            if(head.next == head){
                head = null;
                size--;
            }else{
                Node temp = head;
                while(temp.next != head){
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
                size--;
            }
        }
    }
    public void removeAtEnd(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            if(head.next == head){
                head = null;
                size--;
            }else{
                Node temp = head;
                while(temp.next.next != head){
                    temp = temp.next;
                }
                temp.next = head;
                size--;
            }
        }
    }
    public void removeSpecific(int index){
        if(head == null){
            System.out.println("List is empty");
        }
        if(index <= 0 || index > size-1){
            System.out.println("Invalid index");
        }else{
            if(index == 0){
                removeAtBeginning();
            }else if(index == size-1){
                removeAtEnd();
            }else{
                Node temp = head;
                for(int i = 0; i < index-1; i++){
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }
    }

    // printing the linked list
    public void printList() {
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node temp = head;
            do{
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }while(temp != head);
            System.out.println("\nSize of the LL is - " + size + "\n");
        }
    }

    public static void main(String args[]){
        CircularLL CLL = new CircularLL();
        CLL.addAtBeginning(10);
        CLL.addAtEnd(20);
        CLL.addAtEnd(30);
        CLL.addAtEnd(50);
        CLL.printList();
        CLL.addAtSpecific(40, 3);
        CLL.printList();
        CLL.removeAtBeginning();
        CLL.printList();
        CLL.removeAtEnd();
        CLL.printList();
        CLL.removeSpecific(1);
        CLL.printList();
    }
}