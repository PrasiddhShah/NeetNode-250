class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = {}
        indgrees = [0] * numCourses

        for dep,ind in prerequisites:
            if ind not in graph:
                graph[ind] = []
            graph[ind].append(dep)
            indgrees[dep] += 1
        queue = deque()
        path = []
        for i in range(len(indgrees)):
            if indgrees[i] == 0:
                queue.append(i)
                path.append(i)
                numCourses-=1
        
        while len(queue) != 0:
            cur = queue.popleft()
            for dep in graph.get(cur,[]):
                indgrees[dep] -=1
                if indgrees[dep] ==0:
                    numCourses -= 1
                    queue.append(dep)
                    path.append(dep)
        if numCourses <= 0:
            return path
        else:
            return []
                