/*
    Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

    Example 1 -
        Input - root = [3,1,4,null,2], k = 1
        Output - 1

    Example 2 - 
        Input - root = [5,3,6,2,4,null,null,1], k = 3
        Output - 3
*/

import javax.swing.tree.TreeNode;

public class KthSmallestElementInBST {
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
    private int count = 0;
    private int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode node, int k){
        if(node == null){
            return;
        }
        inorder(node.left, k);
        count++;
        if(count == k){
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }
}