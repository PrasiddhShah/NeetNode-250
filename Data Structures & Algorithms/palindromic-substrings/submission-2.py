class Solution:
    def countSubstrings(self, s: str) -> int:
        dp = [False]*len(s)
        count = 0
        diag = False
        for i in range(len(s)):
            for j in range(i,-1,-1):
                temp = dp[j]
                if s[i] == s[j] and(i-j<2 or diag):
                    dp[j] = True
                    count+=1
                else:
                    dp[j] = False
                diag = temp
        return count