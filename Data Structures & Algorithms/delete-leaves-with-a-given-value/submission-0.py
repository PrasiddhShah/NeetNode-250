# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        return self.dfs(root,target)

    def dfs(self,root,target):
        if root == None:
            return None
        root.left = self.dfs(root.left,target)
        root.right = self.dfs(root.right,target)
        if root.val == target and root.left is None and root.right is None:
            return None
        return root