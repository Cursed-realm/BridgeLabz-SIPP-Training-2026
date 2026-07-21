public class PricingIndexBSTValidator {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node validRoot = new Node(50);
        validRoot.left = new Node(30);
        validRoot.right = new Node(70);

        Node invalidRoot = new Node(50);
        invalidRoot.left = new Node(30);
        invalidRoot.right = new Node(70);
        invalidRoot.left.right = new Node(60);

        System.out.println(isValidBST(validRoot));
        System.out.println(isValidBST(invalidRoot));
    }

    public static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(Node node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
