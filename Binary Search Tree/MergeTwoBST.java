import java.util.*;

public class MergeTwoBST {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void levelorder(Node root){
        if(root == null) {
            return;
        }else{
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node node = q.poll();
                if(node == null){
                    System.out.println();
                    if(!q.isEmpty()){
                        q.add(null);
                    }else{
                        break;
                    }
                }else{
                    System.out.print(node.data + " ");
                    if(node.left != null){
                        q.add(node.left);
                    }
                    if(node.right != null){
                        q.add(node.right);
                    }
                }
            }
        }
    }
    public static void getInorder(Node root, ArrayList<Integer> seq){
        if(root == null) {
            return;
        }
        getInorder(root.left, seq);
        seq.add(root.data);
        getInorder(root.right, seq);
    }
    public static Node createBST(ArrayList<Integer> arr, int start, int end){
        if(start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }
    public static Node merge(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);
        int i = 0, j = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(i < arr1.size() && j < arr2.size()) {
            if(arr1.get(i) < arr2.get(j)) {
                arr.add(arr1.get(i));
                i++;
            }else{
                arr.add(arr2.get(j));
                j++;
            }
        }
        while(i < arr1.size()){
            arr.add(arr1.get(i));
            i++;
        }
        while(j < arr2.size()){
            arr.add(arr2.get(j));
            j++;
        }
        return createBST(arr, 0, arr.size()-1);
    }
    public static void main(String args[]){
        /*
         *       BST 1 -
         *       
         *         2
         *        / \
         *       1   4
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        /* 
         *       BST 2 -
         * 
         *         9
         *        / \
         *       3  12
        */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        System.out.println("BST 1 -");
        levelorder(root1);
        System.out.println("\nBST 2 -");
        levelorder(root2);
        System.out.println("\nMerged BST -");
        Node mergedRoot = merge(root1, root2);
        levelorder(mergedRoot);
    }
}