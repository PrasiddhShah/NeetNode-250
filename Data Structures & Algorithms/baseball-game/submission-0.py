class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack = []
        res = 0

        for ch in operations:
            if ch =='D':
                stack.append(stack[-1]*2)
            elif ch == 'C':
                stack.pop()
            elif ch == '+':
                first = stack[-1]
                second = stack[-2]
                stack.append(first+second)
            else:
                stack.append(int(ch))
        while stack:
            res +=stack.pop()
        return res
