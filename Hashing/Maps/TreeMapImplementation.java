import java.util.TreeMap;

public class TreeMapImplementation {
    // Sorted order main store krta hai
    // Implemented using Red-Black Trees
    // Comparatively higher time complexity - O(logn)
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Banana", 20);
        map.put("Apple", 10);
        map.put("Date", 40);
        map.put("Cherry", 30);
        System.out.println(map);
        // Key order prioritised 
    }
}