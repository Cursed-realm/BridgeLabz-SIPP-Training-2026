import java.util.ArrayList;
import java.util.List;

public class SortedLeaderboardRetriever {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);

        SortedLeaderboardRetriever retriever = new SortedLeaderboardRetriever();
        List<Integer> leaderboard = retriever.getSortedLeaderboard(root);
        System.out.println(leaderboard);
    }

    public List<Integer> getSortedLeaderboard(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
