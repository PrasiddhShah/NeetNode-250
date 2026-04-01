class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        def turnright(c):
            return '0' if c == '9' else chr(ord(c)+1)
        
        def turnleft(c):
            return '9' if c == '0' else chr(ord(c)-1)
        
        def option(word):
            ans = []
            for i in range(4):
                ch = word[i]
                word[i] = turnright(ch)
                ans.append(word[:])
                
                word[i] = turnleft(ch)
                ans.append(word[:])  # copy
                word[i] = ch         # restore original

            return ans

        deadends_set = set(deadends)
        vis = set()
        vis.add("0000")
        if "0000" in deadends_set:
            return -1
        if target == "0000":
            return 0
        q = deque()
        q.append(['0','0','0','0'])
        res = 0
        while q:
            size = len(q)
            for i in range(size):
                cur = q.popleft()
                options = option(cur)
                for single in options:
                    single_string = "".join(single)
                    if single_string == target:
                        return res+1
                    if single_string not in vis and single_string not in deadends_set:
                        q.append(single)
                        vis.add(single_string)
            res+=1
        return -1

