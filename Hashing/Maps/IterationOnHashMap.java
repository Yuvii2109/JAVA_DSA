import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IterationOnHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);

        // Iterating using keySet()
        Set<String> keys = map.keySet();
        System.out.println("Iterating using keySet() -");
        for (String key : keys) {
            System.out.println(key + " - " + map.get(key));
        }

        // Iterating using entrySet()
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("\nIterating using entrySet() -");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}