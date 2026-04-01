import random
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.quicksort(nums,0,len(nums)-1)
        return nums

    def quicksort(self,nums,low,high):
        if low >=high:
            return
        
        partition = self.qs(nums,low,high)
        self.quicksort(nums,low,partition-1)
        self.quicksort(nums,partition+1,high)
    

    def qs(self,nums,low,high):
        rand_idx = random.randint(low, high)
        nums[rand_idx], nums[high] = nums[high], nums[rand_idx]
        pivot = high
        right =left = low
        for right in range(low,high):
            if nums[right] < nums[pivot]:
                nums[right],nums[left] = nums[left],nums[right]
                left+=1
        nums[left],nums[pivot] = nums[pivot],nums[left]
        return left