public class PrintInRange {
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
            // Create a new node if the tree/subtree is empty
            root = new Node(value);
            return root;
        }
        if(root.data > value){
            // If the value is less, go to the left subtree
            root.left = insert(root.left, value);
        }else{
            // Otherwise, go to the right subtree
            root.right = insert(root.right, value);
        }
        // Return the updated tree
        return root;
    }
    public static void printInRange(Node root, int start, int end){
        if(root == null) return;
        // If root's value is within the range, print it and check both subtrees
        if(root.data >= start && root.data <= end) {
            // Check the left subtree
            printInRange(root.left, start, end);
            // Print the root's value
            System.out.print(root.data + " ");
            // Check the right subtree
            printInRange(root.right, start, end);
        }else if(root.data < start){
            // If root's value is less than the start of the range, skip the left subtree
            printInRange(root.right, start, end);
        }else{
            // If root's value is greater than the end of the range, skip the right subtree
            printInRange(root.left, start, end);
        }
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
        printInRange(root, 5, 12);
    }
}

/*
    For the range [5, 12] -

    Start at the root (8) -
    8 is in the range → Check the left and right subtrees.

    Move to the left child (5) -
    5 is in the range → Check its left (3) and right (6).

    Move to 3 -
    3 is less than 5 (start of range) → Skip the left subtree and 
    check the right child (4).

    Move to 4 -
    4 is less than 5 → Skip further.

    Move to 6 -
    6 is in the range → Print it.

    Backtrack to the root (8) and move to the right child (10):
    10 is in the range → Check its right child (11).

    Move to 11 -
    11 is in the range → Print it.

    Move to 14 -
    14 is greater than 12 → Skip further.
*/