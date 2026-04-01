class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n-1:
            return False
        graph = {i:[] for i in range(n)}

        for a,b in edges:
            graph[a].append(b)
            graph[b].append(a)
        
        vist = set()
        self.dfs(graph,vist,0,-1)
        return len(vist) == n

    def dfs(self, graph, path, node,parent):
        path.add(node)

        for neigh in graph[node]:
            if neigh == parent:
                continue
            if neigh in path:
                return
            self.dfs(graph,path,neigh,node)

