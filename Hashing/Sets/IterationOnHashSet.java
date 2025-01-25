import java.util.HashSet;
import java.util.Iterator;

public class IterationOnHashSet {
    public static void main(String[] args) {
        // Create a HashSet
        HashSet<String> names = new HashSet<>();
        names.add("Yuvraj");
        names.add("Mohita");
        names.add("Rajvir");
        names.add("Kashvi");
        names.add("Harsh");
        System.out.println("Using iterator - ");
        Iterator i = names.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("\nUsing advanced loop - ");
        // This can also be done using advanced loops
        for (String name : names) {
            System.out.println(name);
        }
    }
}