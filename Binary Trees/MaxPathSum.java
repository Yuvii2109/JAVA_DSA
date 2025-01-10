// Doesn't matter if we are able to traverse through the entire tree or not
// We just want to find the highest sum achieved by the data in the nodes

import java.util.*;

public class MaxPathSum {
    public static class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Max {
        public int value;
    }

    public static int findMax(Node root, Max m) {
        if (root == null) return 0;

        // Compute the max path sum through the left and right children
        int left = findMax(root.left, m);
        int right = findMax(root.right, m);

        // Maximum path sum including the current node and one of its subtrees
        int maxSingle = Math.max(root.data, Math.max(left, right) + root.data);
        // maxSingle - the maximum path sum that includes the current node 
        // and one of its subtrees. This is the best path sum either from the 
        // left or right child, including the current node.

        // Maximum path sum including the current node and both subtrees
        int maxTop = root.data + left + right;
        // maxTop - the maximum path sum that includes the current node and 
        // both its subtrees. This is used to check if the current node 
        // forms a valid path sum where both children are included.

        // Update the global maximum
        m.value = Math.max(m.value, Math.max(maxSingle, maxTop));

        // Return the max sum path through one of the subtrees plus the current node
        return Math.max(left, right) + root.data;
    }

    public static int findMaxSum(Node root) {
        // This is a wrapper function to initiate the global maximum path 
        // sum (m.value) and start the recursive findMax function. The 
        // result of findMax is stored in m.value and returned as the final 
        // result.
        Max m = new Max();
        m.value = Integer.MIN_VALUE; // Initialize the max path sum to the lowest possible value
        findMax(root, m);
        return m.value; // Return the maximum path sum
    }

    public static void main(String[] args) {
        /*
         *         -10
         *         /  \
         *        9    20
         *            /  \
         *           15   7 
         */
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println("Maximum path sum - " + findMaxSum(root));
    }
}