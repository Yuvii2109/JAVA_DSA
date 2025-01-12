public class ValidateBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Helper function to validate BST
    public static boolean isValidBST(Node root, Integer min, Integer max) {
        // Base case - If the tree is empty, it is a valid BST
        if (root == null) {
            return true;
        }

        // Check if the current node's value violates the BST properties
        if ((min != null && root.data <= min) || (max != null && root.data >= max)) {
            return false;
        }

        // Recursively validate the left and right subtrees
        // The left subtree must have values < root.data
        // The right subtree must have values > root.data
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
        /*
         *         19
         *       /    \
         *     16      21
         *    /  \       \
         *   5    17      23
         */
        Node root = new Node(19);
        root.left = new Node(16);
        root.right = new Node(21);
        root.left.left = new Node(5);
        root.left.right = new Node(17);
        root.right.right = new Node(23);

        // Validate the BST
        if (isValidBST(root, null, null)) {
            System.out.println("BST is valid");
        } else {
            System.out.println("BST is not valid");
        }
    }
}