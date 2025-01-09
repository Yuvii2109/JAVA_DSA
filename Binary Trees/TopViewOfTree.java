import java.util.*;

public class TopViewOfTree {
    // Approach - Levelorder Traversal, Hashmaps, Horizontal Distance
    public static class Node{
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class Info{
        // Represents additional information about each node during traversal.
        Node node;
        int horizontalDistance;
        public Info(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }
    public static void topView(Node root){
        if(root == null) return;

        // Levelorder traversal -
        Queue<Info> q = new LinkedList<Info>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;
        q.add(new Info(root, 0));
        q.add(null); // Jumping to the next line 
        // Queue (q) - Used for level-order traversal.
        // HashMap (map) - Maps each unique horizontal distance (HD) to 
        // the first node at that HD (topmost node).
        // min and max - Track the minimum and maximum horizontal distances.
        // The root node is added to the queue with an HD of 0.

        // Traversal Logic -
        while(!q.isEmpty()){
            Info current = q.poll();
            if(current == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    // null marks the end of the level
                }
            }else{
                // Else main daala to avoi exception as if we don't use else
                // then the following conditions would also work for
                // current == null
                if(!map.containsKey(current.horizontalDistance)){
                    map.put(current.horizontalDistance, current.node); 
                }
                // The map ensures that only the first node encountered at 
                // each HD is stored. If the HD of the current node 
                // (current.horizontalDistance) is not already in the map, 
                // the node is added. This ensures that nodes at higher levels 
                // of the tree (closer to the root) are prioritized for the top view.

                if(current.node.left != null){
                    q.add(new Info(current.node.left, current.horizontalDistance - 1));
                    min = Math.min(min, current.horizontalDistance - 1);
                }
                // For the Left Child -
                // Add the left child of the current node to the queue with 
                // its HD as current.horizontalDistance - 1.
                // Update min to keep track of the smallest HD encountered so far.

                if(current.node.right != null){
                    q.add(new Info(current.node.right, current.horizontalDistance + 1));
                    max = Math.max(max, current.horizontalDistance + 1);
                }
                // For the Right Child:
                // Add the right child of the current node to the queue with 
                // its HD as current.horizontalDistance + 1.
                // Update max to keep track of the largest HD encountered so far.
            }
        }

        // Print the nodes at the top view
        for(int i = min; i <= max; i++){
            System.out.print(map.get(i).data + " ");
        }
    }
    public static void main(String[] args) {
        /*
         *            1
         *           / \
         *          2   3
         *         / \ / \
         *        4  5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Top View of Tree is - ");
        topView(root);
    }
}

// Time complexity - O(n)