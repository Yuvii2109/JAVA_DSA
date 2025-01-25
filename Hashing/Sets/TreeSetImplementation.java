// Sorts in ascending order... NULL values are not allowed...

import java.util.TreeSet;

public class TreeSetImplementation {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<>();
        names.add("Yuvraj");
        names.add("Harsh");
        names.add("Kashvi");
        names.add("Mohita");
        names.add("Rajvir");
        System.out.println(names);
    }
}