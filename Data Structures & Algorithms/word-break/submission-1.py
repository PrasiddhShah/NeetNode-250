class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordset = set(wordDict)
        dp = [False]*(len(s)+1)
        dp[0] = True

        for i in range(1,len(s)+1):
            for j in range(len(s)):
                if dp[j] and (s[j:i] in wordset):
                    dp[i] = True
        return dp[len(s)]