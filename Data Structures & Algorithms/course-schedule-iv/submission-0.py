class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        gr = defaultdict(list)
        indegree = [0]*numCourses

        for indepn,dep in prerequisites:
            indegree[dep] +=1
            gr[indepn].append(dep)
        
        q = deque()

        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
        num_pre = [set() for _ in range(numCourses)]
        
        while q:
            cur = q.popleft()
            for adj in gr[cur]:
                num_pre[adj] |= num_pre[cur] |{cur}
                indegree[adj]-=1
                if indegree[adj] == 0:
                    q.append(adj)
        
        res = []
        
        for query in queries:
            if query[0] in num_pre[query[1]]:
                res.append(True)
            else:
                res.append(False)
        return res