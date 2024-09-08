public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Java");
        
        sb.append(" Programming"); // Appending string
        System.out.println("\n" + sb); // Output: Java Programming
        
        sb.insert(5, "Language "); // Inserting at index 5
        System.out.println(sb); // Output: Java Language Programming
        
        sb.delete(5, 13); // Deleting a portion of the string
        System.out.println(sb); // Output: Java Programming
        
        sb.reverse(); // Reversing the string
        System.out.println(sb + "\n"); // Output: gnimmargorP avaJ
    }
}