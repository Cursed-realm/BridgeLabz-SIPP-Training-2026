public class EmployeeIdInsertionBST {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);

        printInOrder(root);
    }

    public static Node insert(Node node, int id) {
        if (node == null) {
            return new Node(id);
        }
        if (id < node.val) {
            node.left = insert(node.left, id);
        } else if (id > node.val) {
            node.right = insert(node.right, id);
        }
        return node;
    }

    public static void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
}
