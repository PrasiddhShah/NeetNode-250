class Solution:
    def maxArea(self, heights: List[int]) -> int:
        area = 0
        low = 0
        high = len(heights)-1
        while low < high:
            area = max(area,(high-low)*min(heights[high],heights[low]))
            if heights[low] > heights[high]:
                high -=1
            else:
                low +=1
        return area