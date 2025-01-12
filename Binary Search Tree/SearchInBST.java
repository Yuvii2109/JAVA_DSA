public class SearchInBST {
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
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean search(Node root, int value){
        if(root == null){
            return false;
        }
        if(root.data == value){
            return true;
        }
        if(root.data > value){
            return search(root.left, value);
        }else{
            return search(root.right, value);
        }
    }
    public static void main(String args[]){
        int value[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for(int i = 0; i < value.length; i++){
            root = insert(root, value[i]);
        }
        int key = 4;
        if(search(root, key)){
            System.out.println("Value " + key + " present in the BST - ");
            inorder(root);
        }else{
            System.out.println("Value " + key + " not present in the BST - ");
            inorder(root);
        }
    }
}