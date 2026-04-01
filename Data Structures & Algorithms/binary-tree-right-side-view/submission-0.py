# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        ls = []
        if root:
            self.helper(root,ls,0)
        return ls
    
    def helper(self,root,ls,height):
        if root == None:
            return
        
        if len(ls) == height:
            ls.append(root.val)
        self.helper(root.right,ls,height+1)
        self.helper(root.left,ls,height+1)
