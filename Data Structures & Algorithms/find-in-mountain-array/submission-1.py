class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        length = mountainArr.length()

        low,high = 1,length-2

        while low <= high:
            mid = (low+high)//2
            left,center,right = mountainArr.get(mid-1),mountainArr.get(mid),mountainArr.get(mid+1)

            if left < center < right:
                low = mid+1
            elif left > center > right:
                high = mid-1
            else:
                break
        
        peak = mid

        low,high = 0,peak

        while low <=high:
            mid = (low+high)//2
            val = mountainArr.get(mid)

            if  val > target:
                high = mid-1
            elif val < target:
                low = mid+1
            else:
                return mid
        
        low,high = peak+1,length-1

        while low <= high:
            mid = (low+high)//2
            val = mountainArr.get(mid)
            if val < target:
                high = mid - 1
            elif val > target:
                low = mid+1
            else:
                return mid
        return -1