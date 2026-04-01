class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = {}
        indgree = [0] * numCourses
        
        for dep,ind in prerequisites:
            if ind not in graph:
                graph[ind] = []
            graph[ind].append(dep)
            indgree[dep] +=1
        queue = deque()
        for i in range(len(indgree)):
            if indgree[i] == 0:
                queue.append(i)
                numCourses -= 1
        while len(queue) != 0:
            cur = queue.popleft()
            for dep in graph.get(cur, []):
                indgree[dep]-=1
                if indgree[dep]== 0:
                    queue.append(dep)
                    numCourses -=1
        
        return numCourses == 0
