public class UsernameSearchBST {
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
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);

        System.out.println(search(root, 40));
        System.out.println(search(root, 99));
    }

    public static boolean search(Node root, int target) {
        Node current = root;
        while (current != null) {
            if (target == current.val) {
                return true;
            }
            current = (target < current.val) ? current.left : current.right;
        }
        return false;
    }
}
