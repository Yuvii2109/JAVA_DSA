/*
    Given the root of a binary tree, flatten the tree into a "linked list" - The "linked list" should use the same TreeNode class where the right 
    child pointer points to the next node in the list and the left child 
    pointer is always null. The "linked list" should be in the same order 
    as a pre-order traversal of the binary tree.

    Example 1 - 
        Input - root = [1,2,5,3,4,null,6]
        Output - [1,null,2,null,3,null,4,null,5,null,6]

    Example 2 -
        Input - root = []
        Output - []

    Example 3 -
        Input - root = [0]
        Output - [0]
*/

import javax.swing.tree.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left != null){
                TreeNode current = root.left;
                // Find the rightmost node of the left subtree
                while(current.right != null){
                    current = current.right;
                }
                // Connect the right subtree of root to the rightmost node
                current.right = root.right;
                // Move the left subtree to the right
                root.right = root.left;
                root.left = null;
            }
            // Move to the next node in the right-skewed tree
            root = root.right;
        }
    }
}

/*
           1
          / \
         2   5
        / \   \
       3   4   6
       
    Expected Output -
        [1, null, 2, null, 3, null, 4, null, 5, null, 6]
        (i.e., a right-skewed linked list following pre-order traversal - Root → Left → Right)

    Step-by-Step Execution - 

        Start with root = 1
        root.left exists (node 2).
        Find the rightmost node of the left subtree (node 4).
        Connect 4.right = 5 (original right subtree of 1).

        Move root.left to root.right -
            1
             \
              2
             / \
            3   4
                 \
                  5
                   \
                    6
        Set root.left = null and move root = root.right (2).
        Now root = 2
        root.left exists (node 3).
        Rightmost node of left subtree = 3 (no right child).
        Connect 3.right = 4 (original right subtree of 2).

        Move root.left to root.right -
            1
             \
              2
               \
                3
                 \
                  4
                   \
                    5
                     \
                      6
        Set root.left = null and move root = root.right (3).
        Now root = 3
        root.left is null, so move root = root.right (4).
        Now root = 4
        root.left is null, so move root = root.right (5).
        Now root = 5
        root.left is null, so move root = root.right (6).
        Now root = 6
        root.left is null, root.right is null, so we stop.

        Final Flattened Tree (Right-Skewed Linked List) - 
            1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
*/