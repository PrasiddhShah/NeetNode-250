"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return node
        hmap = {}
        q = deque()
        copynode = Node(node.val)
        q.append(node)
        hmap[node] = copynode

        while len(q) !=0:
            cur = q.popleft()
            for n in cur.neighbors:
                if n not in hmap:
                    newNode = Node(n.val)
                    hmap[n] = newNode
                    q.append(n)
                hmap[cur].neighbors.append(hmap[n])
        return copynode