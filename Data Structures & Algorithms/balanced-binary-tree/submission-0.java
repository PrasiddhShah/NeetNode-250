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
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        this.flag = true;;
        dfs(root);
        return flag;
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right =  dfs(root.right);
        int diff = Math.abs(left-right);
        if(diff > 1){
            flag = false;
        }
        return 1+Math.max(left,right);
    }
}
