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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append("#");
            }else{
                sb.append(cur.val);
                q.offer(cur.left);
                q.offer(cur.right);
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] arr = data.split(",");
        int idx = 0;
        if(arr[idx].equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        idx++;
        while(!q.isEmpty() && idx < arr.length){
            TreeNode cur = q.poll();
            if(!arr[idx].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[idx]));
                cur.left = left;
                q.offer(left);
            }
            idx++;
            if(!arr[idx].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[idx]));
                cur.right = right;
                q.offer(right);
            }
            idx++;
        }
        return root;
    }
}
