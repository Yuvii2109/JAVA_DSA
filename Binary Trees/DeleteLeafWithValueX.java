import java.util.*;

public class DeleteLeafWithValueX {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node deleteLeaf(Node root, int x) {
        if (root == null) return null;

        // Recursively call deleteLeaf on left and right subtrees
        root.left = deleteLeaf(root.left, x);
        root.right = deleteLeaf(root.right, x);

        // If current node is a leaf and matches x, return null
        if (root.left == null && root.right == null && root.data == x) {
            return null;
        }

        return root;
    }

    public static void levelTraversal(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                } else {
                    break;
                }
            } else {
                System.out.print(temp.data + " ");

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        /*
         *            1
         *           / \
         *          2   7
         *         / \ 
         *        7  7 
         *   
         *          to -
         *            
         *            1
         *           / 
         *          2   
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(7);
        root.left.right = new Node(7);

        System.out.println("Binary tree before deletion - ");
        levelTraversal(root);

        root = deleteLeaf(root, 7);

        System.out.println("\nBinary tree after deletion - ");
        levelTraversal(root);
    }
}