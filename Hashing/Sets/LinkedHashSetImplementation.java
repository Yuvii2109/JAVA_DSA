// Yeh order maintain krta hai vohi jisme add kiya jaata hai...

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetImplementation {
    public static void main(String[] args) {
        // Creating a HashSet
        HashSet<String> names1 = new HashSet<>();
        names1.add("Yuvraj");
        names1.add("Harsh");
        names1.add("Mohita");
        names1.add("Rajvir");
        names1.add("Kashvi");
        System.out.println("Using hashSet - " + names1);

        // Creating a LinkedHashSet
        LinkedHashSet<String> names2 = new LinkedHashSet<>();
        names2.add("Yuvraj");
        names2.add("Harsh");
        names2.add("Mohita");
        names2.add("Rajvir");
        names2.add("Kashvi");
        System.out.println("Using LinkedHashSet - " + names2);
    }
}