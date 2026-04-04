class Solution:
    def validPalindrome(self, s: str) -> bool:
        i = 0
        j = len(s)-1
        while i <j:
            if s[i] != s[j]:
                return self.isPalin(s,i+1,j) or self.isPalin(s,i,j-1)
            i+=1
            j-=1
        return True
    def isPalin(self, s, i, j):
        while i < j:
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True
