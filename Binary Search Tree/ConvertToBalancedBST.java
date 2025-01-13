import java.util.*;

public class ConvertToBalancedBST {
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
    public static void levelorder(Node root) {
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

    public static void getInorder(Node root, ArrayList<Integer> seq){
        if(root == null){
            return;
        }
        getInorder(root.left, seq);
        seq.add(root.data);
        getInorder(root.right, seq);
    }
    // This method performs an inorder traversal of the BST and stores the 
    // result in the provided ArrayList (seq).
    // Key Points -
    // Inorder Traversal -
    // Visits nodes in the order - Left → Current → Right.
    // For a BST, this traversal outputs a sorted sequence of values.
    // Base Case -
    // If the root is null, it simply returns, effectively ending the 
    // recursion for that branch.
    // Recursive Calls -
    // First traverses the left subtree.
    // Adds the data of the current node to the list.
    // Then traverses the right subtree.

    public static Node createBST(ArrayList<Integer> inorder, int start , int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, start, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root;
    }
    // This method constructs a balanced BST from a sorted list (inorder).
    // Key Points - 
    // Base Case -
    // If start > end, it means the range of elements to process is 
    // invalid (no elements left), so it returns null.
    // Find Middle Element -
    // The middle element of the sorted list becomes the root of the 
    // current subtree.
    // Formula - mid = start + (end - start) / 2.
    // Choosing the middle ensures the height difference between the left 
    // and right subtrees is minimized, keeping the tree balanced.
    // Recursion -
    // The left half of the list (start to mid - 1) is used to build the 
    // left subtree.
    // The right half of the list (mid + 1 to end) is used to build the 
    // right subtree.
    // Return Value
    // The root node of the constructed subtree is returned to the caller.

    public static Node balanceBST(Node root){
        if(root == null){
            return null;
        }
        // Storing the inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // Sorting the inorder sequence to balanced BST
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }
    // Converts an unbalanced BST into a balanced BST.
    // Key Steps -
    // Inorder Traversal -
    // Calls getInorder to generate the inorder traversal of the BST.
    // This results in a sorted list of the BST's elements.
    // Build Balanced BST -
    // Calls createBST to construct a balanced BST using the sorted list.
    // The middle element of the list becomes the root, and the process 
    // is recursively applied to both halves.
    // Return Balanced Root -
    // The newly constructed balanced BST's root is returned.

    public static void main(String args[]){
        /*
         *             8
         *            / \
         *           6  10
         *          /     \
         *         5      11
         *        /         \
         *       3          12
         * 
         *            to -
         * 
         *              8
         *            /   \
         *           /     \
         *          5       11
         *         /  \    /  \
         *        3    6  10  12
         */
        Node root = new Node(8);
        root.left = new Node(6);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.left.right = new Node(11);
        root.left.left.left = new Node(3);
        root.left.right.right = new Node(12); 
        System.out.println("Original tree - ");
        levelorder(root);
        System.out.println("\nBalanced tree - ");
        Node balancedRoot = balanceBST(root);
        levelorder(balancedRoot);
    }
}

// Time complexity - O(n)