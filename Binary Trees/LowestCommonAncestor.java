import java.util.*;

public class LowestCommonAncestor {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        // Finds the path from the root to a target node n.
        // Logic -
        // Base Case - If root == null, return false (node not found).
        // Add the current node (root) to the path.
        // Check if the current node's data matches n. If yes, return true.
        // Recursively search the left and right subtrees. If either 
        // returns true, the node is found. If the node is not in the 
        // current path, remove the current node from path and return false.
        if (root == null) return false;

        path.add(root);

        if (root.data == n) {
            return true;
        }

        if (getPath(root.left, n, path) || getPath(root.right, n, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static Node lowestCommon(Node root, int n1, int n2) {
        if (root == null) return null;

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
            return null; // If either n1 or n2 is not present in the tree
        }

        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
            i++;
        }

        return path1.get(i - 1);
        // Use getPath to find the paths from the root to n1 and n2, 
        // storing them in path1 and path2. If either n1 or n2 is not 
        // found, return null. Compare the nodes in path1 and path2 one 
        // by one until they diverge. Return the last common node before 
        // divergence as the LCA.
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

        Node lca = lowestCommon(root, 4, 5);
        if (lca != null) {
            System.out.println("Lowest Common Ancestor - " + lca.data);
        } else {
            System.out.println("No Common Ancestor Found");
        }
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)