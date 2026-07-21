public class CategoryDepthChecker {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);

        CategoryDepthChecker checker = new CategoryDepthChecker();
        System.out.println(checker.isTooDeep(root, 1));
        System.out.println(checker.isTooDeep(root, 3));
    }

    public boolean isTooDeep(TreeNode root, int threshold) {
        return height(root) > threshold;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
