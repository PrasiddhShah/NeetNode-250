class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        row,col = len(heights),len(heights[0])
        visited = set()
        minheap = [[0,0,0]]
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        while minheap:
            diff,r,c = heapq.heappop(minheap)
            if (r,c) in visited:
                continue
            visited.add((r,c))
            if r == row-1 and c == col-1:
                return diff
            
            for dr,dc in dirs:
                new_row = dr + r
                new_col = dc + c
                if 0 <= new_row < row and 0 <= new_col < col and (new_row,new_col) not in visited:
                    new_effort = max(abs(heights[r][c]- heights[new_row][new_col]),diff)
                    heapq.heappush(minheap,[new_effort,new_row,new_col])