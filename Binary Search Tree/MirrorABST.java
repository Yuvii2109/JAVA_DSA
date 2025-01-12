import java.util.*;

public class MirrorABST {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node mirror(Node root){
        // Base Case
        if(root == null){
            return null;
        }

        Node leftSubtree = mirror(root.left);
        Node rightSubtree = mirror(root.right);

        // Swap left and right subtrees
        root.left = rightSubtree;
        root.right = leftSubtree;
        
        return root;
    }
    public static void levelorder(Node root){
        if (root == null) {
                return;
        }else{
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null); // To skip a line and enter the next level
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if(node == null){
                    System.out.println();
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }else{
                        break;
                    }
                }else{
                    System.out.print(node.data + " ");
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        /*
         *         19
         *       /    \
         *     16      21
         *    /  \       \
         *   5    17      23
         */
        Node root = new Node(19);
        root.left = new Node(16);
        root.right = new Node(21);
        root.left.left = new Node(5);
        root.left.right = new Node(17);
        root.right.right = new Node(23);
        System.out.println("Original Tree - ");
        levelorder(root);
        Node mirrorRoot = mirror(root);
        System.out.println("Mirror of the above tree is - ");
        levelorder(mirrorRoot);
    }
}