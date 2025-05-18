/*
    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node. Note - A leaf is a node with no children. 

    Example 1 -
        Input - root = [3,9,20,null,null,15,7]
        Output - 2

    Example 2 -
        Input - root = [2,null,3,null,4,null,5,null,6]
        Output - 5
*/

import javax.swing.tree.TreeNode;

public class MinimumDepthOfBinaryTree {
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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        // If one of the subtrees is null, we cannot take its depth as 0, because we need a path to a leaf. So we recurse only on the non-null subtree.
        if(root.left == null){
            return 1 + minDepth(root.right);
        }
        if(root.right == null){
            return 1 + minDepth(root.left);
        }
        // If both subtrees are non-null, take the minimum of the two depths
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        return 1 + Math.min(leftMin, rightMin);
    }
}