/*
    Given the root of a complete binary tree, return the number of the nodes in the tree.

    According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

    Design an algorithm that runs in less than O(n) time complexity. 

    Example 1 -
        Input - root = [1,2,3,4,5,6]
        Output - 6

    Example 2 -
        Input - root = []
        Output - 0

    Example 3 -
        Input - root = [1]
        Output - 1
*/

import javax.swing.tree.TreeNode;

public class CountCompleteTreeNodes {
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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = getDepth(root, true);
        int rightDepth = getDepth(root, false);
        if(leftDepth == rightDepth){
            // The tree is perfect - number of nodes = 2^depth - 1
            return (1 << leftDepth) - 1;
        }else{
            // Otherwise, recurse on subtrees +1 for the root itself
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    private int getDepth(TreeNode node, boolean isLeft){
        int depth = 0;
        while(node != null){
            depth++;
            node = isLeft ? node.left : node.right;
        }
        return depth;
    }
}