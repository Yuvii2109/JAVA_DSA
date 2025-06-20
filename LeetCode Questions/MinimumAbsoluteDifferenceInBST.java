/*
    Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree. 

    Example 1 -
        Input - root = [4,2,6,1,3]
        Output - 1

    Example 2 -
        Input - root = [1,0,48,null,null,12,49]
        Output - 1
*/

import javax.swing.tree.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
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

    // prev holds the value of the previously visited node in in‑order
    private Integer prev = null;
    // minDiff accumulates the smallest difference seen so far
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    private void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        if(prev != null){
            int gap = node.val - prev;
            if(gap < minDiff){
                minDiff = gap;
            }
        }
        prev = node.val;
        inorder(node.right);
    }
}