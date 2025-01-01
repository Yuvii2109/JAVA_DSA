import java.util.*;

public class UsingJCF {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        // Ab hmne LinkedList isliye likha kyunki Queue is not a class 
        // it is an interface and it is implemented by LinkedList class
        // Java main bas 2 classes hain jinse queue implement ho skte hain
        // 1. LinkedList
        // 2. ArrayDeque
        // Queue ka apna koi object nahi ban skta kyuki vo interface hai...
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);
        while(!q.isEmpty()){
            System.out.println(q.poll());
            // What is the function of poll() -
            // It removes the head of the queue and returns the element that was removed.
            // If the queue is empty, it returns null.
        }
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println(q);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        System.out.println(q.peek());
    }
}