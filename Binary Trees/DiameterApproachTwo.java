public class DiameterApproachTwo {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Helper class to store height and diameter together
    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo diameterOptimized(Node root) {
        // Base case - height and diameter are both 0
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        // Recursively get height and diameter of left and right subtrees
        TreeInfo leftInfo = diameterOptimized(root.left);
        TreeInfo rightInfo = diameterOptimized(root.right);

        // Height of the current node is the maximum height of left and right subtrees + 1
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        // Diameter passing through the current node
        int selfDiameter = leftInfo.height + rightInfo.height + 1;

        // Maximum diameter so far
        int diameter = Math.max(selfDiameter, Math.max(leftInfo.diameter, rightInfo.diameter));

        return new TreeInfo(height, diameter);
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

        TreeInfo result = diameterOptimized(root);
        System.out.println("Diameter of the tree is - " + result.diameter);
    }
}

// Time complexity - O(n)