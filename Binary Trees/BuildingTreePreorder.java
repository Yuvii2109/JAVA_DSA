import java.util.*;

public class BuildingTreePreorder {
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
    public static class BinaryTree{
        public static int index = -1;

        // Time Complexity - O(n)
        public static Node buildTree(int[] arr) {
            index++;
            if (arr[index] == -1) {
                return null;
            }else{
                Node newNode = new Node(arr[index]);
                newNode.left = buildTree(arr);
                newNode.right = buildTree(arr);
                return newNode;
            }
        }

        // Preorder Traversal - O(n) -> (Root-Left-Right)
        public static void preorder(Node root) {
            if (root == null) {
                return;
            }else{
                System.out.print(root.data + " ");
                preorder(root.left);
                preorder(root.right);
            }
        }

        // Inorder Traversal - O(n) -> (Left-Root-Right)
        public static void inorder(Node root) {
            if (root == null) {
                return;
            }else{
                inorder(root.left);
                System.out.print(root.data + " ");
                inorder(root.right);
            }
        }

        // Postorder Traversal - O(n) -> (Left-Right-Root)
        public static void postorder(Node root) {
            if (root == null) {
                return;
            }else{
                postorder(root.left);
                postorder(root.right);
                System.out.print(root.data + " ");
            }
        }

        // Levelorder Traversal - O(n) -> Levelwise traversal 
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
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root of the tree is - " + root.data);
        System.out.println("\nPreorder traversal - ");
        tree.preorder(root);
        System.out.println("\nInorder traversal - ");
        tree.inorder(root);
        System.out.println("\nPostorder traversal - ");
        tree.postorder(root);
        System.out.println("\nLevelorder traversal - ");
        tree.levelorder(root);
    }
}