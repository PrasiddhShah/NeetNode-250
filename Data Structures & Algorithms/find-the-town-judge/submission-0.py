class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indgree = [0]*(n+1)

        for t,nt in trust:
            indgree[t]-=1
            indgree[nt]+=1
        for i in range(1,n+1):
            if indgree[i] == n-1:
                return i
        return -1