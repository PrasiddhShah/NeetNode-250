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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       //base
        if(preorder.length == 0) return null;

        //logic
        int root = preorder[0];
        int rootidx = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root){
                rootidx = i;
                break;
            }
        }
        TreeNode newroot = new TreeNode(root);
        int []inleft = Arrays.copyOfRange(inorder,0,rootidx);
        int []inright = Arrays.copyOfRange(inorder,rootidx+1,inorder.length);

        int []preleft = Arrays.copyOfRange(preorder,1,1+inleft.length);
        int []preright = Arrays.copyOfRange(preorder,inleft.length+1,preorder.length);

        newroot.left = buildTree(preleft,inleft);
        newroot.right = buildTree(preright,inright);
        return newroot;   
    }
}
