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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if((p == null && q!= null) || (p != null && q==null)){
            return false;
        }
        this.flag = true;
        helper(p,q);
        return flag;
        
    }
    public void helper(TreeNode p, TreeNode q){
        if(p == null || q == null || flag == false){
            if((p == null && q!= null) || (p != null && q==null)){
                flag = false;
            }
            return;
        }

         if(p.val != q.val ){
            flag = false;
        }
        helper(p.left,q.left);
        helper(p.right,q.right);
        return;
    }
}