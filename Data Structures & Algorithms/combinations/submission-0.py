class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        self.res = []
        self.k = k
        self.backtrack(n,1,[])
        return self.res
    
    def backtrack(self,n,idx,path):
        if len(path) == self.k:
            self.res.append(path[:])
            return
        

        for i in range(idx,n+1):
            path.append(i)
            self.backtrack(n,i+1,path)
            path.pop()