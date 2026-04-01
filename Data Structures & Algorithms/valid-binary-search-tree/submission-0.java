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
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return false;
        }
        return dfs(root);
    }
    private boolean dfs(TreeNode root){
        if(root == null){
            return true;
        }
        
        boolean left = dfs(root.left);
        if(prev != null && root.val <=prev.val){
            return false;
        }
        prev = root;
        boolean right = dfs(root.right);
        return  left && right;
    }
}
