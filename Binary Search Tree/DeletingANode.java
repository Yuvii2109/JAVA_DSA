// Case 1 - No child(leaf node) -> Delete node and return null to parent
// Case 2 - One child -> Delete node and replace with child node
// Case 3 - Two children -> Replace value with inorder successor/predecessor
// and delete the node for inorder successor/predecessor

public class DeletingANode {
    public static class Node{
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static Node insert(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(root.data > value){
            root.left = insert(root.left, value);
        }else{
            root.right = insert(root.right, value);
        }
        return root;
    }
    public static Node deleteNode(Node root, int key) {
        if(root == null) return root;
        if(root.data > key) {
            root.left = deleteNode(root.left, key);
        }else if(root.data < key) {
            root.right = deleteNode(root.right, key);
        }else {
            if(root.left == null) {
                return root.right;
            }else if(root.right == null) {
                return root.left;
            }else{
                // Case 1 - Leaf node
                if(root.left == null && root.right == null){
                    return null;
                } 
                // Case 2 - One child
                if(root.left == null){
                    return root.right;
                }else if(root.right == null){
                    return root.left;
                }
                // Case 3 - Two children
                Node successor = findInorderSuccessor(root.right);
                root.data = successor.data; // Replacing values with successor node
                root.right = deleteNode(root.right, successor.data);
                // deleting the successor node
                /*
                 * Ya phir find the inorder predecessor -
                 * 
                 * Node predecessor = findInorderPredecessor(root.left);
                 * root.data = predecessor.data;
                 * root.left = deleteNode(root.left, predecessor.data);
                 */
            }
        }
        return root;
    }
    /*
     * public static Node findInorderPredecessor(Node root){
     *      // Keep traversing right to find the maximum value
     *      while(root.right != null){
     *          root = root.right
     *      }
     *      return root;
     * }
     */
    public static Node findInorderSuccessor(Node root){
        // Keep traversing left to find the smallest value
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int[] value = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        /*
         *  BST - 
         *               8
         *             /   \
         *            5     10
         *           / \      \
         *          3   6      11
         *         /  \          \ 
         *        1     4         14
         */
        Node root = null;
        for(int i = 0; i < value.length; i++){
            root = insert(root, value[i]);
        }
        int key = 10;
        System.out.println("Inorder Traversal of the BST - ");
        inorder(root);
        System.out.println("\nDeleting Node with value " + key);
        root = deleteNode(root, key);
        System.out.println("Inorder Traversal of the BST after deletion - ");
        inorder(root);
    }
}