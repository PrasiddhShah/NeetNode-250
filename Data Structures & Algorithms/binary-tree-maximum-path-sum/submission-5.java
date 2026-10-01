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
    int best;
    public int maxPathSum(TreeNode root) {
        best = -2000;
        dfs(root);
        return best;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        best = Math.max(best, root.val + Math.max(0, left) + Math.max(0, right));
        int child = Math.max(0, Math.max(left, right));
        return root.val + child;
    }
}
