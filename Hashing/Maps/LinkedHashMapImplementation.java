import java.util.LinkedHashMap;

public class LinkedHashMapImplementation {
    public static void main(String[] args) {
        // Create a LinkedHashMap
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println(map); // Jis order main daaloge usi main save hoga
    }
}