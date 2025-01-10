// Checking if the given binary tree is univalued or not. 

public class UnivalueCheck {
    public static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean isUniTree(Node root) {
        if (root == null) return true;
        if (root.left != null && root.left.data != root.data) return false;
        if (root.right != null && root.right.data != root.data) return false;
        return isUniTree(root.left) && isUniTree(root.right);
    }
    public static void main(String[] args) {
        /*
        *            7
        *           / \
        *          7   7
        *         / \ / \
        *        7  7 7  7
        */
        Node root = new Node(7);
        root.left = new Node(7);
        root.right = new Node(7);
        root.left.left = new Node(7);
        root.left.right = new Node(7);
        root.right.left = new Node(7);
        root.right.right = new Node(7);
        if(isUniTree(root)){
            System.out.println("The binary tree is univalued.");
        }else{
            System.out.println("The binary tree is not univalued.");
        }
    }
}