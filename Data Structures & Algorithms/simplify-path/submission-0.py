class Solution:
    def simplifyPath(self, path: str) -> str:
        path_ls = path.split("/")
        stack = []

        for p in path_ls:
            if p == "." or p == "":
                continue
            elif p == "..":
                if stack:
                    stack.pop()
            else:
                stack.append(p)
        
        if not stack:
            return "/"
        return "/" + "/".join(stack)