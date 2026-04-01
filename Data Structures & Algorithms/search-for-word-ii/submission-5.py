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
    def search(self,node,word):
        cur = node
        for ch in word:
            if ch not in cur.children:
                return None
            cur = cur.children[ch]
        return cur

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        self.dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        self.res = []
        self.root = Trie()
        self.idxpath = set()
        self.path = []
        for word in words:
            self.insert(word)
        for i in range(len(board)):
            for j in range(len(board[0])):
                node = self.search(self.root,board[i][j])
                if node is not None:
                    self.path.append(board[i][j])
                    self.idxpath.add((i,j))
                    if node.end:
                        node.end = False
                        self.res.append("".join(self.path))
                    self.dfs(board,node,i,j)
                    self.idxpath.remove((i,j))
                    self.path.pop()
        return self.res
        
    
    def dfs(self,board,node,i,j):
        for dir in self.dirs:
            newRow = dir[0] + i
            newCol = dir[1] + j
            if newRow >=0 and newCol >= 0 and newRow < len(board) and newCol < len(board[0]):
                if (newRow,newCol) not in self.idxpath:
                    self.idxpath.add((newRow,newCol))
                    self.path.append(board[newRow][newCol])
                    re = self.search(node,board[newRow][newCol])
                    if re is not None:
                        if re.end:
                            re.end = False
                            self.res.append("".join(self.path))
                        self.dfs(board,re,newRow,newCol)
                    self.idxpath.remove((newRow,newCol))
                    self.path.pop()
        