public class CountNodes {
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
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    public static void main(String[] args){
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
        System.out.println("Number of nodes in the tree is - " + countNodes(root));
    }
}