class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        trips.sort(key=lambda x:x[1])

        cur_load = 0
        pq = []
        for trip in trips:
            while pq and trip[1] >=  pq[0][0]:
                cur_load -= pq[0][1]
                heapq.heappop(pq)
            if cur_load + trip[0] <= capacity:
                heapq.heappush(pq,[trip[2],trip[0]])
                cur_load +=trip[0]
            else:
                return False
        return True