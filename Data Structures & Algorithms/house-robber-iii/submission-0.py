# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        return max(self.dfs(root))

    def dfs(self,root):
        if root is None:
            return (0,0)
        
        left = self.dfs(root.left)
        right = self.dfs(root.right)
        rob = root.val + left[1] + right[1]
        skip = max(left) + max(right)
        return (rob,skip)