// We hava an absolute path for a file (Unix-style), simplify it. 
// Note that absolute path always begin with ‘/’ ( root directory ), a 
// dot in path represent current directory and double dot represents
// parent directory.
// Sample Input 1 : /yuvraj/
// Sample Output 1 : /yuvraj
// Sample Input 2 : /a/..
// Sample Output 2 : /

import java.util.*;

public class SimplifyPath {
    public static String simplify(String A) {
        Stack<String> stack = new Stack<>();
        // A Stack<String> is used to store valid directory names in the path.
        int len_A = A.length();

        for (int i = 0; i < len_A; i++) {
            // Skip consecutive slashes
            // The loop iterates through the path string.
            // Consecutive slashes (//) are treated as a single slash.
            while (i < len_A && A.charAt(i) == '/') {
                i++;
            }

            // Extract the directory name
            StringBuilder dir = new StringBuilder();
            while (i < len_A && A.charAt(i) != '/') {
                dir.append(A.charAt(i));
                i++;
            }
            String dirStr = dir.toString();
            // Characters between slashes are collected into a StringBuilder, 
            // which represents a directory name or special component (. or ..).
            // dirStr holds the extracted string.

            if (dirStr.equals("..")) {
                // Move one directory up, if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // If .. is encountered, the last directory is removed (if the 
                // stack is not empty) to move up one directory level.
            } else if (!dirStr.equals(".") && !dirStr.isEmpty()) {
                // Add valid directory names
                stack.push(dirStr);
            } else {
                // Ignore empty strings and .
                continue;
            }
        }

        // Build the final simplified path from the stack
        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.append("/").append(dir);
        }
        // The : in for (String dir : stack) separates the element being 
        // iterated (dir) from the collection being looped over (stack). 
        // It is used in a for-each loop, making the iteration concise and 
        // readable.

        // Return "/" if stack is empty, otherwise return the constructed path
        return res.length() > 0 ? res.toString() : "/";
    }

    public static void main(String[] args) {
        String str1 = "/yuvraj/";
        String str2 = "/a/../";
        String str3 = "/yuvraj//sachdeva/";
        String str4 = "/../";

        System.out.println(simplify(str1)); 
        System.out.println(simplify(str2)); 
        System.out.println(simplify(str3)); 
        System.out.println(simplify(str4)); 
    }
}

// Linear Time Complexity - O(n)