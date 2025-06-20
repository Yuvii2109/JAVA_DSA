/*
    Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted. 

    Example 1 - 
        Input - root = [3,9,20,null,null,15,7]
        Output - [3.00000,14.50000,11.00000]
        Explanation - The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
        Hence return [3, 14.5, 11].

    Example 2 -
        Input - root = [3,9,20,15,7]
        Output - [3.00000,14.50000,11.00000]
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class AverageOfLevelsInBinaryTree {
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        if(root == null) return averages;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            long levelSum = 0;
            for(int i = 0; i < levelSize; i++){
                TreeNode node = q.poll();
                levelSum += node.val;
                if (node.left  != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            averages.add(levelSum / (double) levelSize);
        }
        return averages;
    }
}