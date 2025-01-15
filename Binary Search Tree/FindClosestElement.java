// We have a binary search tree and a target node K. The task is to find
// the node with minimum absolute difference with given target value K.

public class FindClosestElement {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static int findClosest(Node root, int target) {
        // Initialize variables to keep track of the closest value
        int closest = root.data;
        Node current = root;

        while (current != null) {
            // Update closest if the current node is closer to the target
            if (Math.abs(target - current.data) < Math.abs(target - closest)) {
                closest = current.data;
            }

            // Move left or right depending on the value of the target
            if (target < current.data) {
                current = current.left;
            } else if (target > current.data) {
                current = current.right;
            } else {
                // Exact match found, break early
                break;
            }
        }
        return closest;
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

        int target = 12;
        int closest = findClosest(root, target);
        System.out.println("The closest value to " + target + " is " + closest);
    }
}