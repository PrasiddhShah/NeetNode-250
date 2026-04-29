class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low = 0 
        high = 0
        for weight in weights:
            low = max(low,weight)
            high+=weight
        
        
        while low <= high:
            mid = low + (high-low)//2
            curwt  = 0
            curday = 1
            for weight in weights:
                if curwt+weight > mid:
                    curwt=weight
                    curday+=1
                else:
                    curwt+=weight
            if curday <=days:
                high = mid-1
            else:
                low = mid + 1
        return low

