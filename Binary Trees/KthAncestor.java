public class KthAncestor {
    public static class Node{
        int data;
        Node left,right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static int kthAncestor(Node root, int n, int k) {
        // Base Cases -
        // If the root is null, return -1 (indicating the node 
        // doesn't exist in this path).
        // If the current node's data matches the target (n), 
        // return 0 (distance to itself is 0).
        if (root == null) {
            return -1; // Base case: Tree traversal ends if node is null
        }
        if (root.data == n) {
            return 0; // Found the target node, return distance as 0
        }
        
        // Recursive Search -
        // Recursively search for the node in the left and right 
        // subtrees (leftDistance and rightDistance).
        // If both return -1, the node is not found in this subtree.
        int leftDistance = kthAncestor(root.left, n, k); // Search left subtree
        int rightDistance = kthAncestor(root.right, n, k); // Search right subtree
        if (leftDistance == -1 && rightDistance == -1) {
            return -1; // Node not found in either subtree
        }

        // Distance Calculation -
        // The variable max stores the larger of the two distances 
        // (leftDistance or rightDistance).
        // One of them will contain the distance to the target node, 
        // while the other will be -1.
        // If max == -1, it means the target node is not present in this 
        // subtree, so return -1.
        // Check if the current distance (max + 1) equals k. 
        // If it does, the current node is the kth ancestor.
        int max = Math.max(leftDistance, rightDistance); // Distance from child to target node
        if (max == -1) {
            return -1; // No ancestor found
        }
        if (max + 1 == k) {
            System.out.println(root.data); // Print the kth ancestor
        }

        // Add 1 to the distance (max) and return it to the parent call, 
        // indicating the distance from the target node as the traversal 
        // moves upward in the tree.
        return max + 1; // Increment distance as we move up the tree
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
        int k = 2;
        int node = 4;
        System.out.print(k + "nd ancestor of " + node + " is ");
        kthAncestor(root, node, k);
    }
}

/* 
    
    Execution Flow -

    At Node 1 -
    Calls kthAncestor on root.left (Node 2).
    Calls kthAncestor on root.right (Node 3).

    At Node 2 -
    Calls kthAncestor on root.left (Node 4).
    Calls kthAncestor on root.right (Node 5).

    At Node 4 -
    Returns 0 (distance to itself is 0).

    At Node 2 -
    leftDistance = 0 (Node 4 is found in the left subtree).
    rightDistance = -1 (Node 5 does not contain the target).
    max = 0, so max + 1 = 1.
    Returns 1 to Node 1.

    At Node 1 -
    leftDistance = 1 (Node 4 is found in the left subtree).
    rightDistance = -1.
    max = 1, so max + 1 = 2 (matches k=2).
    Prints 1 (the 2nd ancestor).

*/

// Time complexity - O(n)