class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        high = 0
        low = 0
        for weight in weights:
            high += weight
            low = max(weight,low)
        
        while low <= high:
            mid = low +(high-low)//2
            curday = 1
            curwt = 0
            for weight in weights:
                if curwt + weight > mid:
                    curwt=weight
                    curday+=1
                else:
                    curwt+=weight
            if curday <=days:
                high = mid -1
            else:
                low = mid+1
        return low