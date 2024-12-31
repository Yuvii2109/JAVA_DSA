import java.util.*;

public class PallindromeLL {
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
    public int size = 0;
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
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
    public boolean isPallindrome(){
        if(head == null || head.next == null){
            return true;
        }else{
            Node temp = head;
            boolean isPallin = true;
            Stack<Integer> s = new Stack<>();
            while(temp != null){
                s.push(temp.data);
                temp = temp.next;
            }
            while(head != null){
                if(head.data != s.pop()){
                    isPallin = false;
                    break;
                }else{
                    head = head.next;
                }
            }
            return isPallin;
        }
    }
    public static void main(String[] args) {
        PallindromeLL LL = new PallindromeLL();
        LL.add(1);
        LL.add(2);
        LL.add(3);
        LL.add(3);
        LL.add(2);
        LL.add(1);
        LL.printLL();
        if(LL.isPallindrome()){
            System.out.println("The Linked List is a Pallindrome");
        }else{
            System.out.println("The Linked List is not a Pallindrome");
        }
    }
}

// Linear Time Complexity - O(n)