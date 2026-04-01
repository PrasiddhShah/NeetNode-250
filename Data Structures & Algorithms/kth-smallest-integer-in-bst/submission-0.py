# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        pq = []
        self.helper(root,pq,k)
        return -pq[0]
    
    def helper(self,root,pq,k):
        if root == None:
            return

        
        heapq.heappush(pq, -root.val)
        if len(pq) > k:
            heapq.heappop(pq)
        
        self.helper(root.left,pq,k)
        self.helper(root.right,pq,k)