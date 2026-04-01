# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        mainLS = []
        subLS = []
        self.helper(root,mainLS)
        self.helper(subRoot,subLS)
        return ''.join(subLS) in ''.join(mainLS)
    
    def helper(self, root,ls):
        if root == None:
            ls.append(",null")
            return
        ls.append(","+str(root.val))
        self.helper(root.left,ls)
        self.helper(root.right,ls)