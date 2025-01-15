// Greater Sum Tree Transformation - For a given BST, transform it such that 
// each node contains the sum of all nodes in the original BST that are 
// greater than or equal to that node.

// Two Sum BSTs - Given two BSTs, find the number of pairs (node1, node2) 
// where node1 is from the first BST, node2 is from the second BST, and 
// their sum equals x.

import java.util.*;

public class TwoSumsBSTs {
    // Node class for the BST
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Transform the BST into a Greater Sum Tree
    public static int transformToGreaterSumTree(Node root, int sum) {
        if (root == null) return sum;

        // Traverse right subtree first
        sum = transformToGreaterSumTree(root.right, sum);

        // Update the node's value
        int originalValue = root.data;
        root.data += sum;

        // Traverse left subtree
        return transformToGreaterSumTree(root.left, root.data);
    }
    // Transforms a BST into a Greater Sum Tree, where each node contains 
    // the sum of all nodes greater than or equal to it.

    // Parameters -
    // root - The current node being processed.
    // sum - The cumulative sum of all greater nodes visited so far.

    // Working -

    // Base Case -
    // If root is null, return sum (cumulative sum remains unchanged).

    // Right Subtree Traversal -
    // Visit the right subtree first (reverse in-order traversal) to
    // process the largest nodes first.
    // Accumulate the sum of nodes from the right subtree.

    // Update Current Node -
    // Add the cumulative sum to the current node's value.
    // Update sum to include the current node's original value.

    // Left Subtree Traversal -
    // Recursively process the left subtree.

    // Perform in-order traversal to store values in a list
    public static void inOrderTraversal(Node root, List<Integer> list) {
        if (root == null) return;

        inOrderTraversal(root.left, list);
        list.add(root.data);
        inOrderTraversal(root.right, list);
    }
    // Performs in-order traversal of a BST and stores the node values in 
    // a list in sorted order.

    // Parameters -

    // root - The current node being processed.
    // list - A List<Integer> to collect the values of the nodes.

    // Working -

    // Traverse the left subtree (all smaller nodes).
    // Add the current node's value to the list.
    // Traverse the right subtree (all larger nodes).

    // Find pairs from two BSTs that sum to x
    public static int findPairsWithSum(Node root1, Node root2, int x) {
        // Get sorted lists of values from both BSTs
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inOrderTraversal(root1, list1); // Collect values from the first tree
        inOrderTraversal(root2, list2); // Collect values from the second tree

        // Use two-pointer technique to find pairs
        int count = 0;
        int i = 0, j = list2.size() - 1;

        while (i < list1.size() && j >= 0) {
            int sum = list1.get(i) + list2.get(j);
            if (sum == x) {
                System.out.println("Pair - (" + list1.get(i) + ", " + list2.get(j) + ")");
                count++;
                i++;
                j--;
            } else if (sum < x) {
                i++; // Move the pointer in the first list forward
            } else {
                j--; // Move the pointer in the second list backward
            }
        }
        return count;
    }
    // Finds and counts pairs (node1, node2) such that node1 is from the 
    // first BST, node2 is from the second BST, and their sum equals x.

    // Steps -
    // Use in-order traversal to collect sorted lists of node values 
    // (list1 and list2).
    // Use the two-pointer technique:
    // i - Points to the smallest value in list1.
    // j - Points to the largest value in list2.
    // Calculate the sum of the pair (list1[i], list2[j]).
    // If the sum matches x, print the pair and move both pointers.
    // If the sum is smaller than x, increment i to increase the sum.
    // If the sum is larger than x, decrement j to decrease the sum.
    // Continue until the pointers cross.

    public static void main(String[] args) {
        /*      First BST -
         *
         *          5
         *        /   \
         *       3     7
         *      / \   / \
         *     2   4 6   8 
         */
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        /*      Second BST -
         *
         *           10
         *         /    \ 
         *        6      15  
         *       / \    /  \  
         *      3   8  11  18
         */
        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        int x = 16;

        // Find pairs with sum x
        int count = findPairsWithSum(root1, root2, x);
        System.out.println("Number of pairs with sum " + x + " - " + count);
    }
}

/*
    Tree 1 Transformation -

    Start from the rightmost node (8). It has no greater nodes -
        Node 8 → Sum = 8 (unchanged).

    Move to node 7 -
        Sum of greater nodes = 8.
        Node 7 → New Value = 7 + 8 = 15.

    Move to node 6 -
        Sum of greater nodes = 15.
        Node 6 → New Value = 6 + 15 = 21.

    Move to root node (5) -
        Sum of greater nodes = 21.
        Node 5 → New Value = 5 + 21 = 26.

    Move to left subtree -

        Node 4 → Sum of greater nodes = 26.
        Node 4 → New Value = 4 + 26 = 30.

        Node 3 → Sum of greater nodes = 30.
        Node 3 → New Value = 3 + 30 = 33.

        Node 2 → Sum of greater nodes = 33.
        Node 2 → New Value = 2 + 33 = 35.

    Transformed Tree 1 -

           26
         /    \
        33     15
       /  \   /  \
      35  30 21   8


    Tree 2 Transformation -

    Start from the rightmost node (18). It has no greater nodes -
        Node 18 → Sum = 18 (unchanged).

    Move to node 15 -
        Sum of greater nodes = 18.
        Node 15 → New Value = 15 + 18 = 33.

    Move to node 11 -
        Sum of greater nodes = 33.
        Node 11 → New Value = 11 + 33 = 44.

    Move to root node (10) -
        Sum of greater nodes = 44.
        Node 10 → New Value = 10 + 44 = 54.

    Move to left subtree -

        Node 8 → Sum of greater nodes = 54.
        Node 8 → New Value = 8 + 54 = 62.

        Node 6 → Sum of greater nodes = 62.
        Node 6 → New Value = 6 + 62 = 68.

        Node 3 → Sum of greater nodes = 68.
        Node 3 → New Value = 3 + 68 = 71.

    Transformed Tree 2 -

            54
          /    \
         68     33
        /  \   /  \
       71  62 44  18
*/