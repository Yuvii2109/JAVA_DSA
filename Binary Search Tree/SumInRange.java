public class SumInRange {
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

    public static Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static int sumInRange(Node root, int start, int end) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Include the current node's value if it lies in the range
        if (root.data >= start && root.data <= end) {
            sum += root.data;
        }

        // Check left subtree if necessary
        if (root.data > start) {
            sum += sumInRange(root.left, start, end);
        }

        // Check right subtree if necessary
        if (root.data < end) {
            sum += sumInRange(root.right, start, end);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] value = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        /*
         *  BST - 
         *               8
         *             /   \
         *            5     10
         *           / \      \
         *          3   6      11
         *         /  \          \ 
         *        1     4         14
         */
        Node root = null;
        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }
        int L = 5;
        int R = 12;
        System.out.println("Sum of the range [" + L + ", " + R + "] - " + sumInRange(root, L, R));
    }
}