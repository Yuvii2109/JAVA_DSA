import java.util.*;

public class InterleaveTwoHalves {
    public static void interleave(Queue<Integer> q){
        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();
        int size = q.size();
        for(int i = 0; i < size/2; i++){
            first.add(q.poll());
        }
        for(int i = 0; i < size/2; i++){
            second.add(q.poll());
        }
        while(!first.isEmpty() && !second.isEmpty()){
            q.add(first.poll());
            q.add(second.poll()); 
        }
        if(!first.isEmpty()){
            while(!first.isEmpty()){
                q.add(first.poll());
            }
        }else{
            while(!second.isEmpty()){
                q.add(second.poll());
            }
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interleave(q);
        while(!q.isEmpty()){
            System.out.print(q.poll() + " ");
        }
    }
}