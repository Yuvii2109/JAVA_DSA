public class SortedArrayToBalancedBST {
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
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static Node createBST(int arr[], int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }
    public static void main(String[] args){
        // Sorted array -
        int[] arr = {3, 5, 6, 8, 10, 11, 12};
        /*
         *           8
         *         /   \
         *        5     11
         *       / \   /  \
         *      3   6 10  12
         */
        Node root = createBST(arr, 0, arr.length - 1);
        System.out.println("Inorder traversal of the constructed BST - ");
        inorder(root);
    }
}