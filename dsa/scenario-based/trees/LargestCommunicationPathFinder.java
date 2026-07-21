public class LargestCommunicationPathFinder {
    private int diameter = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);

        LargestCommunicationPathFinder finder = new LargestCommunicationPathFinder();
        System.out.println(finder.longestCommunicationPath(root));
    }

    public int longestCommunicationPath(TreeNode root) {
        diameter = 0;
        heightAndUpdateDiameter(root);
        return diameter;
    }

    private int heightAndUpdateDiameter(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = heightAndUpdateDiameter(node.left);
        int rightHeight = heightAndUpdateDiameter(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight + 2);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
