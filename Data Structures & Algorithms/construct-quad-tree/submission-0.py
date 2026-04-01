"""
# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""

class Solution:
    def construct(self, grid: List[List[int]]) -> 'Node':
        return self.dfs(len(grid),0,0,grid)

    def dfs(self,n,r,c,grid):
        allsame = True
        for i in range(n):
            for j in range(n):
                if grid[r][c] != grid[r+i][c+j]:
                    allsame = False
                    break
        
        if allsame:
            return Node(grid[r][c],True)
        
        n =n//2
        topleft = self.dfs(n,r,c,grid)
        topright = self.dfs(n,r,c+n,grid)
        bottomleft = self.dfs(n,r+n,c,grid)
        bottomright = self.dfs(n,r+n,c+n,grid)
        return Node(0,False,topleft,topright,bottomleft,bottomright)