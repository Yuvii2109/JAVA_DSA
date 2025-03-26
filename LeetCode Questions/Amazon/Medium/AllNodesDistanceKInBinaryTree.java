/*
    Given the root of a binary tree, the value of a target node target, 
    and an integer k, return an array of the values of all nodes that have 
    a distance k from the target node. You can return the answer in any 
    order. 

    Example 1 -
        Input - root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4], 
        target = 5, k = 2
        Output - [7,4,1]
        Explanation - The nodes that are a distance 2 from the target node 
        (with value 5) have values 7, 4, and 1.
    
    Example 2 -
        Input - root = [1], target = 1, k = 3
        Output - []
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class AllNodesDistanceKInBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    
    // Maps each node in the tree to its parent node. By building this parentMap, we allow each node to have a reference to its parent, enabling traversal up the tree.
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        List<Integer> result = new ArrayList<>();
        if(root == null || k < 0) return result;
        buildParentMap(root, null); // Populates parentMap, linking each node to its parent.
        Queue<TreeNode> q = new LinkedList<>(); // To perform BFS
        Set<TreeNode> visited = new HashSet<>(); // To track nodes that have already been processed (to avoid cycles).
        q.offer(target);
        visited.add(target);
        int currentLevel = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(currentLevel == k){
                for(int i = 0; i < size; i++){
                    TreeNode node = q.poll();
                    result.add(node.val);
                }
                return result;
            }
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null && visited.add(node.left)){
                    // If it has a left child that hasn't been visited, we enqueue it.
                    q.offer(node.left);
                }
                if(node.right != null && visited.add(node.right)){
                    // If it has a right child that hasn't been visited, we enqueue it.
                    q.offer(node.right);
                }
                TreeNode parentNode = parentMap.get(node);
                if(parentNode != null && visited.add(parentNode)){
                    // If it has a parent (from parentMap) that hasn't been visited, we enqueue it.
                    q.offer(parentNode);
                }
                // visited.add(node.left) returns true if the node was not already in the set, and false if it was already present. It ensures we do not revisit nodes, avoiding infinite loops.
            }
            currentLevel++;
        }
        return result;
    }
    private void buildParentMap(TreeNode node, TreeNode parent){
        // This function performs a DFS traversal of the tree. This ensures each node in the tree has a reference to its parent, enabling BFS traversal to move upwards when needed.
        if(node == null) return;
        parentMap.put(node, parent);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }
}

/*
        3
       / \
      5   1
     /\   /\
    6  2 0  8
      / \
     7   4
    
    After buildParentMap -
        parentMap -
            3 -> null
            5 -> 3
            1 -> 3
            6 -> 5
            2 -> 5
            0 -> 1
            8 -> 1
            7 -> 2
            4 -> 2
    
    distanceK(root, target, k) - Initialize result, q (a queue for BFS), visited (to track visited nodes), and currentLevel. Enqueue target (node with value 5) into q and mark it as visited.

    First iteration - 
        q has [5], currentLevel is 0.
        Dequeue 5 - 
            Enqueue its children 6 and 2.
            Enqueue its parent 3.

    Second iteration -
        q has [6, 2, 3], currentLevel is 1.
        Dequeue 6, 2, and 3 -  
            Enqueue 7, 4, 0, and 1.

    Third iteration -
        q has [7, 4, 0, 1], currentLevel is 2.
        Dequeue 7, 4, and 1 -
            Add their values to result.

    End of iterations -
        result now contains [7, 4, 1].

    Return result - [7, 4, 1] is the final output for nodes at distance k = 2 from target = 5.
*/