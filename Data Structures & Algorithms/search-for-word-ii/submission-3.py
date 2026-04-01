class Trie:
    def __init__(self):
        self.children = {}
        self.end = False
class Solution:
    def insert(self,word):
        cur = self.root
        for ch in word:
            if ch not in cur.children:
                cur.children[ch] = Trie()
            cur = cur.children[ch]
        cur.end = True
    def search(self,word):
        cur = self.root
        for ch in word:
            if ch not in cur.children:
                return 1
            cur = cur.children[ch]
        if cur.end:
            return 3
        return 2

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        self.dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        self.res = set()
        self.root = Trie()
        self.idxpath = set()
        self.path = []
        for word in words:
            self.insert(word)
        for i in range(len(board)):
            for j in range(len(board[0])):
                re = self.search(board[i][j])
                if re != 1:
                    self.path.append(board[i][j])
                    self.idxpath.add((i,j))
                    if re == 3:
                        self.res.add("".join(self.path))
                    self.dfs(board,i,j)
                    self.idxpath.remove((i,j))
                    self.path.pop()
        return list(self.res)
        
    
    def dfs(self,board,i,j):
        for dir in self.dirs:
            newRow = dir[0] + i
            newCol = dir[1] + j
            if newRow >=0 and newCol >= 0 and newRow < len(board) and newCol < len(board[0]):
                if (newRow,newCol) not in self.idxpath:
                    self.idxpath.add((newRow,newCol))
                    self.path.append(board[newRow][newCol])
                    re = self.search(self.path)
                    if re != 1:
                        if re == 3:
                            self.res.add("".join(self.path))
                        self.dfs(board,newRow,newCol)
                    self.idxpath.remove((newRow,newCol))
                    self.path.pop()