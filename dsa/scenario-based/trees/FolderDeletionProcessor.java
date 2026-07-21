public class FolderDeletionProcessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);

        FolderDeletionProcessor processor = new FolderDeletionProcessor();
        processor.deleteFolderTree(root);
        System.out.println(root.left);
        System.out.println(root.right);
    }

    public void deleteFolderTree(TreeNode node) {
        if (node == null) {
            return;
        }
        deleteFolderTree(node.left);
        deleteFolderTree(node.right);
        node.left = null;
        node.right = null;
    }
}
