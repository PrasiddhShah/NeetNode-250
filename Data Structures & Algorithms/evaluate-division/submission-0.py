class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        graph = defaultdict(dict)
        for i in range(len(values)):
            graph[equations[i][0]][equations[i][1]] = values[i]
            graph[equations[i][1]][equations[i][0]] = 1/values[i]
        res = []
        for source,dest in queries:
            if source not in graph or dest not in graph:
                res.append(-1.0)
            else:
                res.append(self.dfs(source,dest,graph,set(),1))
        return res    
    

    def dfs(self,source,dest,graph,visited,ans):
        if source in visited:
            return -1.0
        visited.add(source)
        if source == dest:
            return ans
        
        for new_source,weight in graph[source].items():
            result = self.dfs(new_source,dest,graph,visited,ans*weight)
            if result != -1.0:
                return result
        return -1.0