import java.util.*;

public class AVLTree {
    public static class Node{
        int data, height;
        Node left, right;
        public Node(int data) {
            this.data = data;
            height = 1;
        }
    }
    public static Node root;
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }
    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }
    public static Node rightRotate(Node k){
        Node node = k.left;
        Node temp = node.right;

        // Rotate 
        node.right = k;
        k.left = temp;

        // Update heights
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }
    public static Node leftRotate(Node k){
        Node node = k.right;
        Node temp = node.left;

        // Rotate
        node.left = k;
        k.right = temp;

        // Update heights
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }
    public static Node insert(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key < root.data){
            root.left = insert(root.left, key);
        }else if(key > root.data){
            root.right = insert(root.right, key);
        }else{
            return root; // Preventing insertion of duplicate key
        }

        // Updating height of root
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Determining Balancing factor of the root 
        int balance = getBalance(root);

        // LL rotation -
        if(balance > 1 && key < root.left.data){
            return rightRotate(root);
        }

        // RR rotation -
        if(balance < -1 && key > root.right.data){
            return leftRotate(root);
        }

        // LR rotation -
        if(balance > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RL rotation -
        if(balance < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
    public static void levelorder(Node root){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node == null){
                System.out.println();
                if(!queue.isEmpty()){
                    queue.add(null);
                }else{
                    break;
                }
            }else{
                System.out.print(node.data + " ");
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
    }
    public static void main(String[] args) {
        /*
         * BST Entered -
         * 
         *     10
         *       \
         *       20
         *         \
         *         30
         *        /  \
         *      25   40
         *             \
         *             50  
         */
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        /*
         * AVL tree formed - 
         * 
         *          30
         *        /    \
         *       20    40
         *      /  \     \
         *     10  25    50
         */
        levelorder(root);
    }
}