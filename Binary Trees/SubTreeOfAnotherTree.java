// Given the roots of 2 binary trees root and subroot, return true if there
// exists a subtree of root with the same structure and node values of subroot 
// and false otherwise

public class SubTreeOfAnotherTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean isSubtree(Node root, Node subroot) {
        if(subroot == null) return true;
        if(root == null) return false;
        if(root.data == subroot.data){
            if(isIdentical(root, subroot)){
                return true;
            }
        }
        // return leftExists || rightExists;
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }
    public static boolean isIdentical(Node root, Node subroot) {
        if(root == null && subroot == null) return true;
        if(root == null || subroot == null) return false;
        if(root.data != subroot.data) return false;
        return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
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

        /*
         *      2
         *     / \
         *    4   5
         */
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);
        if(isSubtree(root, subroot)){
            System.out.println("Subtree exists");
        }else{
            System.out.println("Subtree does not exist");
        }
    }
}