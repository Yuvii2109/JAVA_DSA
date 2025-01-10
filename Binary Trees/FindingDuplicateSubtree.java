import java.util.*;

public class FindingDuplicateSubtree {
    public static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static HashMap<String, Integer> map; // Global declaration

    public static void printDuplicates(Node root) {
        map = new HashMap<String, Integer>();
        inorder(root);
    }
    // This method -
    // Initializes the map to track subtree occurrences.
    // Calls the inorder method to traverse the tree and identify duplicates.

    public static String inorder(Node root){
        if(root == null) return "";
        String str = "";
        str += inorder(root.left);
        str += Integer.toString(root.data);
        str += inorder(root.right);
        str += " ";
        // Traverse the Tree -
        // Recursively visit the left subtree, root, and then the right 
        // subtree (in-order traversal). Append the results to form a 
        // serialized representation of the subtree. Append a space (" ") 
        // to distinguish subtrees with identical structures but different 
        // numbers of nodes.

        if(map.get(str) != null && map.get(str) == 1){
            System.out.println("Duplicate subtree found - " + str);
        }
        // Logic Behind the Condition -
        // map.get(str) != null - Ensures the subtree serialization str 
        // exists in the map.
        // map.get(str) == 1 - Ensures this is the second occurrence of 
        // the subtree.
        // When a subtree is encountered for the second time, it is 
        // recognized as a duplicate, so it prints the message.
        // Subsequent occurrences of the same subtree will not trigger 
        // the message again, as the count will exceed 1.

        // Why Only Print on map.get(str) == 1?
        // This prevents duplicate messages.
        // For example, if a subtree is found three times, it only prints 
        // the message once (when it's seen for the second time).

        if(map.containsKey(str)){
            map.put(str, map.get(str) + 1);
        }else{
            map.put(str, 1);
        }
        // Update the Map -
        // If the subtree already exists in the map, increment its count.
        // Otherwise, add the subtree to the map with a count of 1.

        return str;
    }
    public static void main(String[] args){
        /*
        *            1
        *           / \
        *          4   3
        *         /   / \
        *        3   4   3
        *           /
        *          3
        */
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.right.left.left = new Node(3);
        printDuplicates(root);
    }
}

/*
Execution Flow -
    Step 1 - Main Method Execution
    Node root is constructed to form the binary tree.
    printDuplicates(root) is called, initializing map and starting the 
    traversal with inorder(root).

    Step 2 - Traversing the Tree (inorder Calls)

        2.1 First Call to inorder(root)
            Current node - 1
            Call inorder(root.left) (left subtree of 1).

        2.2 Call to inorder(root.left)
            Current node - 4
            Call inorder(root.left) (left subtree of 4).

        2.3 Call to inorder(root.left.left)
            Current node - 3
            Call inorder(root.left) and inorder(root.right) (both null).
            Leaf Node Processed
            Both child calls return "".
            Serialize subtree - "3 "
            Add "3 " to map with count 1.
            Return "3 " to the parent.

        2.4 Back to 4
            Left subtree serialized - "3 ".
            Process 4.
            Call inorder(root.right) (right subtree of 4, which is null).
            Subtree Processed
            Right child returns "".
            Serialize subtree - "3 4 "
            Add "3 4 " to map with count 1.
            Return "3 4 " to the parent.

        2.5 Back to 1
            Left subtree serialized - "3 4 ".
            Process 1.
            Call inorder(root.right) (right subtree of 1).

        2.6 Call to inorder(root.right)
            Current node - 3
            Call inorder(root.left) (left subtree of 3).

        2.7 Call to inorder(root.right.left)
            Current node - 4
            Call inorder(root.left) (left subtree of 4).

        2.8 Call to inorder(root.right.left.left)
            Current node - 3
            Call inorder(root.left) and inorder(root.right) (both null).
            Duplicate Leaf Node Detected
            Serialize subtree - "3 ".
            map.get("3 ") == 1 → Print: "Duplicate subtree found - 3 "
            Increment count of "3 " in map to 2.
            Return "3 " to the parent.

        2.9 Back to 4
            Left subtree serialized - "3 ".
            Process 4.
            Call inorder(root.right) (right subtree of 4, which is null).
            Subtree Processed
            Right child returns "".
            Serialize subtree - "3 4 ".
            map.get("3 4 ") == 1 → Print: "Duplicate subtree found - 3 4 "
            Increment count of "3 4 " in map to 2.
            Return "3 4 " to the parent.

        2.10 Back to 3
            Left subtree serialized - "3 4 ".
            Process 3.
            Call inorder(root.right) (right subtree of 3).

        2.11 Call to inorder(root.right.right)
            Current node - 3
            Call inorder(root.left) and inorder(root.right) (both null).
            Duplicate Leaf Node Detected
            Serialize subtree - "3 ".
            Increment count of "3 " in map to 3.
            Return "3 " to the parent.

        2.12 Back to 3
            Right subtree serialized - "3 ".
            Serialize subtree - "3 4 3 3 ".
            Add "3 4 3 3 " to map with count 1.
            Return "3 4 3 3 " to the parent.

        2.13 Back to 1
            Right subtree serialized - "3 4 3 3 ".
            Serialize entire tree - "3 4 1 3 4 3 3 ".
            Add "3 4 1 3 4 3 3 " to map with count 1.
            Return "3 4 1 3 4 3 3 ".
    
    Step 3 - Output
    Duplicate subtrees printed during the traversal - 2

    "3 "
    "3 4 "

    Final map State
    "3 " → 3 occurrences
    "3 4 " → 2 occurrences
    "3 4 3 3 " → 1 occurrence
    "3 4 1 3 4 3 3 " → 1 occurrence
*/