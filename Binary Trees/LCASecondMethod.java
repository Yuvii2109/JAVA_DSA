public class LCASecondMethod {
    public static class Node{
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node lowestCommon(Node root, int n1, int n2){
        if(root == null) return null;
        if(root.data == n1 || root.data == n2) return root;
        Node left = lowestCommon(root.left, n1, n2);
        Node right = lowestCommon(root.right, n1, n2);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
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

        Node lca = lowestCommon(root, 4, 6);
        if (lca != null) {
            System.out.println("Lowest Common Ancestor - " + lca.data);
        } else {
            System.out.println("No Common Ancestor Found");
        }
    }
}

// Time complexity - O(n)
// Space complexity - O(1)