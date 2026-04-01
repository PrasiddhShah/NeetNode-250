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
    int height;
    public int maxDepth(TreeNode root) {
        this.height = 0;

        helper(root,1);
        return height;
    }
    public void helper(TreeNode root,int cur){
        if(root == null) return;

        height = Math.max(cur, height);

        helper(root.left,cur+1);
        helper(root.right,cur+1);
        return;


    }
}