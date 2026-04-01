class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False


class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        cur = self.root
        for ch in word:
            if cur.children[ord(ch) - ord("a")] == None:
                cur.children[ord(ch) - ord("a")] = TrieNode()
            cur = cur.children[ord(ch) - ord("a")]
        cur.isEnd = True

    def dfs(self, root, word, index):
        if index == len(word):
            return root.isEnd

        ch = word[index]
        if ch == ".":
            for child in root.children:
                if child is not None:
                    if self.dfs(child, word, index + 1):
                        return True
            return False
        else:
            if root.children[ord(ch) - ord("a")] is None:
                return False
            return self.dfs(root.children[ord(ch) - ord("a")], word, index + 1)

    def search(self, word: str) -> bool:
        cur = self.root
        return self.dfs(cur, word, 0)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
