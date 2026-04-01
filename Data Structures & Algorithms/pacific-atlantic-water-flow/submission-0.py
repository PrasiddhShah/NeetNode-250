class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        p_que = deque()
        p_seen = set()

        a_que = deque()
        a_seen = set()
        m,n = len(heights),len(heights[0])
        for i in range(m):
            p_que.append((i,0))
            p_seen.add((i,0))
        for j in range(n):
            p_que.append((0,j))
            p_seen.add((0,j))

        for i in range(m):
            a_que.append((i,n-1))
            a_seen.add((i,n-1))
        for j in range(n):
            a_que.append((m-1,j))
            a_seen.add((m-1,j))

        p_set = self.helper(heights,m,n,p_que,p_seen)
        a_set = self.helper(heights,m,n,a_que,a_seen)
        return list(p_set.intersection(a_set))
    def helper(self,heights,rowL,colL,q,seen):
        coord = set()

        while q:
            i,j = q.popleft()
            coord.add((i,j))
            for i_off,j_off in [(0,1),(1,0),(-1,0),(0,-1)]:
                r,c = i + i_off, j + j_off
                if rowL > r >=0 and colL > c >=0 and heights[r][c] >= heights[i][j] and (r,c) not in seen:
                    seen.add((r,c))
                    q.append((r,c))
        return coord