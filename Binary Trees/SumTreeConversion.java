/*
 *            1
 *           / \
 *          2   3      
 *         / \ / \
 *        4  5 6  7
 *
 *           to -
 *
 *            27
 *           /  \
 *          9   13
 *         / \  / \
 *        0  0  0  0
 */

public class SumTreeConversion {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int sumConversion(Node root) {
        if (root == null) return 0;

        // Recursive calls for left and right subtrees
        int leftSum = sumConversion(root.left);
        int rightSum = sumConversion(root.right);

        // Store current node's original data
        int data = root.data;

        // Update current node's data to sum of subtree nodes
        root.data = leftSum + rightSum;

        // Return the total sum of subtree + current node's original data
        return data + root.data;
    }

    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
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

        System.out.println("Preorder traversal of original tree is -");
        preorder(root);

        System.out.println("\n\nTransformed tree is -");
        sumConversion(root);
        preorder(root);
    }
}

/*
    Execution Breakdown for Root Node 1 -

    The method recursively processes the left and right subtrees -

    For the left subtree rooted at 2 -

    Recursively computes sums for its left and right children (4 and 5).
    Updates 2's value to 4+5=9. 
    Returns 9+2=11 to the root node.

    For the right subtree rooted at 3 -
    Recursively computes sums for its left and right children (6 and 7).
    Updates 3's value to 6+7=13.
    Returns 13+3=16 to the root node.

    At the root node (1) - 
    Updates its value to 11+16=27 (sum of left and right subtree sums).
    Returns 27+1=28 (final total tree sum). 
*/