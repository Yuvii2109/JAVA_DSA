import java.util.LinkedList;

public class JCFApproachForLL {
    public static void main(String args[]){
        // Creation - int, float, boolean use nahi kar skte
        // Inki jagah Integer class, String class, Float class
        // Character class... yeh sab use krna padega
        LinkedList<Integer> LL = new LinkedList<>();

        // Addition -
        LL.add(10); // [10]
        LL.addLast(20); // [10, 20]
        LL.addFirst(0); // [0, 10, 20]
        LL.add(30); // [0, 10, 20, 30]
        LL.add(2, 15); // [0, 10, 15, 20, 30]
        System.out.println(LL); // [0, 10, 15, 20, 30]

        // Removal -
        LL.removeFirst(); // [10, 15, 20, 30]
        LL.removeLast(); // [10, 15, 20]
        LL.remove(1); // [10, 20]
        System.out.println(LL); // [10, 20]
    }
}