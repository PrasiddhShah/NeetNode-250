class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        self.res = []
        self.dfs(s,set(wordDict),0,[])
        return self.res


    def dfs(self,s,wordset,idx,path):
        if idx == len(s):
            self.res.append(" ".join(path))
            return
        
        for i in range(idx,len(s)):
            cur = s[idx:i+1]
            if cur in wordset:
                path.append(cur)
                self.dfs(s,wordset,i+1,path)
                path.pop()
        