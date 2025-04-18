public class SumNode {
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
    public static int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }else{
            int leftSum = sumNodes(root.left);
            int rightSum = sumNodes(root.right);
            return root.data + leftSum + rightSum; 
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
        System.out.println("Sum of nodes of the tree is - " + sumNodes(root));
    }
}