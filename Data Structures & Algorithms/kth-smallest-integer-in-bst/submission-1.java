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
    int num;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }
    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        num++;
        if (num == k) {
            res = root.val;
        }
        dfs(root.right, k);
    }
}
