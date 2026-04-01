class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        self.pq = [-x for x in stones]
        heapq.heapify(self.pq)
        while len(self.pq) > 1:
            first = heapq.heappop(self.pq)
            second = heapq.heappop(self.pq)
            if first !=second:
                heapq.heappush(self.pq, first - second)
        
        if self.pq:
            return -self.pq[0]
        return 0