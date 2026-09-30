/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder sb_root = new StringBuilder();
        StringBuilder sb_sub = new StringBuilder();
        dfs(sb_root, root);
        dfs(sb_sub, subRoot);
        return sb_root.toString().contains(sb_sub.toString());
    }
    private void dfs(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append('#').append(',');
            return;
        }
        sb.append(root.val).append(',');
        dfs(sb, root.left);
        dfs(sb, root.right);
    }
}
