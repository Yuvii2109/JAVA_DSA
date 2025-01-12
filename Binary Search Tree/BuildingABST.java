public class BuildingABST {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int data){
            value = data;
            left = null;
            right = null;
        }
    }
    public static Node insert(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(root.value > value){
            root.left = insert(root.left, value);
        }else{
            root.right = insert(root.right, value);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }
    public static void main(String[] args){
        int[] value = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for(int i = 0; i < value.length; i++){
            root = insert(root, value[i]);
        }
        System.out.println("Inorder traversal through the BST - ");
        // If in ascending order, then the BST is formed perfectly...
        inorder(root);
    }
}