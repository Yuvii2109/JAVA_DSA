public class MinDistanceBetweenNodes {
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
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
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
    public static int lcaDistance(Node root, int n){
        // Calculates the distance from the given node (root) to a target 
        // node (n). Logic -
        // If root is null, return -1 (node not found).
        // If the current node matches the target (n), return 0 (distance
        // to itself is 0).
        // Recursively calculate the distance in the left and right subtrees.
        // If the node is found in one subtree, return the distance from 
        // that subtree incremented by 1.
        // If the node is not found in either subtree, return -1.
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0; 
        }
        int leftDistance = lcaDistance(root.left, n);
        int rightDistance = lcaDistance(root.right, n);
        if(leftDistance == -1 && rightDistance == -1){
            return -1;
        }else if(leftDistance == -1){
            return rightDistance + 1;
        }else{
            return leftDistance + 1;
        }
    }
    public static int minDistance(Node root, int n1, int n2){
        Node lca = lowestCommon(root, n1, n2);
        int distance1 = lcaDistance(lca, n1);
        int distance2 = lcaDistance(lca, n2);
        return distance1 + distance2;
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
        System.out.println("Minimum distance between nodes 4 and 6 = " + minDistance(root, 4, 6));
    }
}

// Time complexity - O(n) in the worst case when the tree is skewed