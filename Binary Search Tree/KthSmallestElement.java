// We have the root of a binary search tree and K as input, find Kth 
// smallest element in the BST.

public class KthSmallestElement {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
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

    public static class Counter {
        int count = 0; // Tracks the number of nodes visited
        int result = -1; // Stores the Kth smallest element
    }

    public static void inOrder(Node node, Counter counter, int k) {
        if (node == null || counter.count >= k) {
            return;
        }

        // Traverse the left subtree
        inOrder(node.left, counter, k);

        // Process the current node
        counter.count++;
        if (counter.count == k) {
            counter.result = node.data;
            return;
        }

        // Traverse the right subtree
        inOrder(node.right, counter, k);
    }

    public static int kthSmallest(Node root, int k) {
        Counter counter = new Counter();
        inOrder(root, counter, k);
        return counter.result;
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
        int k = 5;
        System.out.println(k + "th smallest element is " + kthSmallest(root, k));
    }
}

/*
    Start with the root node (8) -
        Traverse left subtree of 8 (go to node 5).

    At node 5 -
        Traverse left subtree of 5 (go to node 3).

    At node 3 -
        Traverse left subtree of 3 (go to node 1).

    At node 1 -
        Traverse left subtree (null) - Return.

    Process node 1 -
        Increment counter.count = 1.
        Traverse right subtree (null) - Return.

    Back to node 3 -
        Process node 3 -
            Increment counter.count = 2.
            Traverse right subtree of 3 (go to node 4).

    At node 4 -
        Traverse left subtree (null) - Return.
        Process node 4 -
            Increment counter.count = 3.
            Traverse right subtree (null) - Return.

    Back to node 5 -
        Process node 5 -
            Increment counter.count = 4.
            Traverse right subtree of 5 (go to node 6).

    At node 6 -
        Traverse left subtree (null) - Return.
        Process node 6 -
            Increment counter.count = 5.
            counter.count == k (5), so,
            Store counter.result = 6.
            Return immediately (no further traversal required).
*/