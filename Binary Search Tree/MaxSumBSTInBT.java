// We have a binary tree, the task is to print the maximum sum of nodes of 
// a sub-tree which is also a Binary Search Tree.

public class MaxSumBSTInBT {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static class Info {
        // Stores metadata about a subtree during traversal.
        int max; // Maximum value in the subtree
        int min; // Minimum value in the subtree
        int sum; // Sum of the subtree if it's a BST
        boolean isBST; // Indicates if the subtree is a BST

        public Info(boolean isBST, int max, int min, int sum) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }

    static int maxSum = 0; // Global variable to track the maximum sum

    public static int maxSumBST(Node root) {
        maxSum = 0; // Initialize global maxSum
        traverse(root);
        return maxSum;
    }

    private static Info traverse(Node root) {
        // Base case - If the node is null, treat it as a valid BST with sum 0
        if (root == null) {
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        // Recursively traverse the left and right subtrees
        Info leftInfo = traverse(root.left);
        Info rightInfo = traverse(root.right);

        // Check if the current subtree rooted at "root" is a BST
        if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max && root.data < rightInfo.min) {
            // Calculate the sum of the current subtree
            int sum = root.data + leftInfo.sum + rightInfo.sum;
            maxSum = Math.max(maxSum, sum); // Update the global maximum sum

            return new Info(true, Math.max(root.data, rightInfo.max), 
                            Math.min(root.data, leftInfo.min), 
                            sum);
        } else {
            // If not a BST, return false with dummy values
            return new Info(false, 0, 0, 0);
        }
    }

    public static void main(String[] args) {
        /*
         *            5
         *          /   \
         *         9     2
         *        /       \
         *       6         3
         *      / \
         *     8   7  
         */
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.right.right = new Node(3);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);

        System.out.println("Maximum Sum of the BST in BT - " + maxSumBST(root)); 
    }
}