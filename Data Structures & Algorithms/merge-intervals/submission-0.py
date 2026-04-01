class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        merged = []
        intervals.sort(key=lambda x:x[0])
        first = intervals[0]
        for i in range(1,len(intervals)):
            if intervals[i][0] <= first[1]:
                first[1] = max(first[1],intervals[i][1])
            else:
                merged.append(first)
                first = intervals[i]
        merged.append(first)
        return merged