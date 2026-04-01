class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        q = deque()
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == 0:
                    q.append([row,col])
        while q:
            cur = q.popleft()
            for dir in dirs:
                nrow = cur[0] + dir[0]
                ncol = cur[1] + dir[1]
                if (0 <= nrow < len(grid) and 
                    0 <= ncol < len(grid[0]) and 
                    grid[nrow][ncol] == 2147483647):
                    grid[nrow][ncol] = grid[cur[0]][cur[1]] + 1
                    q.append([nrow, ncol])
