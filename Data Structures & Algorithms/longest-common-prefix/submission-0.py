class Trie:
    def __init__(self):
        self.child = {}
        self.end = False
class Solution:
    def insert(self,root,word):
        cur = root
        for ch in word:
            if ch not in cur.child:
                cur.child[ch] = Trie()
            cur = cur.child[ch]
        cur.end = True
    def search(self, root, ch):
        if ch in root.child:
            return root.child[ch]
        return None

    def longestCommonPrefix(self, strs: List[str]) -> str:
        root = Trie()
        for word in strs:
            self.insert(root,word)
        
        word = strs[0]
        res = []
        node = root
        for ch in word:
            if len(node.child) != 1 or node.end:
                break
            node = self.search(node, ch)
            if node is None:
                break
            res.append(ch)
          
        return "".join(res)

        