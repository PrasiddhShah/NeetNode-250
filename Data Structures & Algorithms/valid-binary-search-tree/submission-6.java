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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return false;
        }
        List<Integer> inorder = new ArrayList<>();
        dfs(root,inorder);
        for(int i = 1; i < inorder.size();i++){
            if(inorder.get(i)<=inorder.get(i-1)){
                return false;
            }
        }
        return true;
    }
    private void dfs(TreeNode root,List<Integer> inorder){
        if(root == null){
            return;
        }
        dfs(root.left,inorder);
        inorder.add(root.val);
        dfs(root.right,inorder);

    }
}
