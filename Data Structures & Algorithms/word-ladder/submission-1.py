import string
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordset = set(wordList)
        q = deque()
        q.append(beginWord)
        res = 0
        if beginWord in wordset:
            wordset.remove(beginWord)
        
        while q:
            size = len(q)
            res+=1
            for i in range(size):
                cur = q.popleft()
                if cur == endWord:
                    return res
                for i in range(len(cur)):
                    cur_ls = list(cur)
                    for ch in string.ascii_lowercase:
                        cur_ls[i] = ch
                        new_cur = "".join(cur_ls)
                        if new_cur in wordset:
                            q.append(new_cur)
                            wordset.remove(new_cur)
        return 0