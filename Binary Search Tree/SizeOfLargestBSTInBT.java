public class SizeOFLargestBSTInBT {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static class Info {
        // Stores metadata about a subtree during traversal.
        int max; // Maximum value in the subtree
        int min; // Minimum value in the subtree
        int size; // Size of the largest BST in the subtree
        boolean isBST; // Indicates if the subtree is a BST

        public Info(boolean isBST, int max, int min, int size) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }

    public static Info largestBST(Node root) {
        if (root == null) {
            // If the node is null, it is a BST of size 0
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        // If the current node (root) is null, the subtree is considered 
        // a valid BST of size 0. It returns Info with -
        // isBST = true
        // max = Integer.MIN_VALUE (no meaningful maximum for an empty tree)
        // min = Integer.MAX_VALUE (no meaningful minimum for an empty tree)
        // size = 0

        // Get information from the left and right subtrees
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        // Current node's size
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // Check if current subtree is a BST
        if (leftInfo.isBST && rightInfo.isBST &&
            root.data >= leftInfo.max && root.data <= rightInfo.min) {
            // If it is a BST, return updated Info
            return new Info(true, max, min, size);
        }
        // For the subtree rooted at root to be a BST:
        // The left subtree must be a BST (leftInfo.isBST).
        // The right subtree must be a BST (rightInfo.isBST).
        // The current node's value (root.data) must be greater than the 
        // maximum value in the left subtree (leftInfo.max).
        // The current node's value must be less than the minimum value in 
        // the right subtree (rightInfo.min).

        // If not a BST, return the largest BST size found in the subtrees
        return new Info(false, max, min, Math.max(leftInfo.size, rightInfo.size));
    }

    public static int findLargestBST(Node root) {
        // Calls the largestBST method on the tree's root node and retrieves 
        // the size of the largest BST.
        return largestBST(root).size;
    }

    public static void main(String[] args) {
        /*
         *                50
         *              /    \
         *            30      60
         *           /  \    /  \
         *          5   20  45  70
         *                     /  \
         *                    65  80
         */
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        int largestBSTSize = findLargestBST(root);
        System.out.println("Largest BST size - " + largestBSTSize);
    }
}