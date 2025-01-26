/*
    Input -
             20
            /  \
           8   22
          / \    \
         5   3   25
            / \
           10 14
           
    Output - 5 10 3 14 25
*/

import java.util.TreeMap;

public class BottomViewOfBinaryTree {

    // Definition of a Tree Node
    public static class Node {
        int data;
        int horizontalDistance;
        Node left, right;

        // Constructor
        public Node(int data) {
            this.data = data;
            this.horizontalDistance = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    // Method to populate the bottom view map
    public static void bottomView(Node root, int current, int horizontalDistance, TreeMap<Integer, int[]> map) {
        // TreeMap - stores horizontal distances as keys and arrays [data, depth] as values.
        if (root == null) return;

        // If node for a particular horizontal distance doesn't exist, add it to the map
        if (!map.containsKey(horizontalDistance)) {
            map.put(horizontalDistance, new int[]{root.data, current});
        } else {
            // If a node already exists for the horizontal distance, check the depth. Compare depths, Replace the entry if the current node is deeper
            if (current >= map.get(horizontalDistance)[1]) {
                map.put(horizontalDistance, new int[]{root.data, current});
            }
        }

        // Recursively process left and right subtrees
        bottomView(root.left, current + 1, horizontalDistance - 1, map);
        bottomView(root.right, current + 1, horizontalDistance + 1, map);
    }

    // Driver method to print bottom view
    public static void printBottomView(Node root) {
        TreeMap<Integer, int[]> map = new TreeMap<>();
        bottomView(root, 0, 0, map);

        // Print the bottom view from the map
        for (int[] value : map.values()) {
            System.out.print(value[0] + " ");
        }
    }

    // Main method
    public static void main(String[] args) {
        // Constructing the tree
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        // Printing the bottom view
        System.out.println("Bottom view of the binary tree - ");
        printBottomView(root);
    }
}

// Time complexity - O(nlogK)