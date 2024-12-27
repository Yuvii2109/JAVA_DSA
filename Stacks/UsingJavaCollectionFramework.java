import java.util.*;

public class UsingJavaCollectionFramework {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Stack - " + s);
        while(!s.isEmpty()){
            System.out.println("Popped element - " + s.pop());
        }
    }
}