public class InvertABinaryTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void printTree(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }
    public static Node invert(Node root){
        if(root == null){
            return root;
        }

        // Swapping - 
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
        return root;
    }
    public static void main(String[] args) {
        /*
        *            1
        *           / \
        *          2   3
        *         / \ / \
        *        4  5 6  7
        *      
        *           to -
        *
        *            1
        *           / \
        *          3   2
        *         / \ / \
        *        7  6 5  4
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("Original Tree - ");
        printTree(root);
        root = invert(root);
        System.out.println("\nInverted Tree - ");
        printTree(root);
    }
}