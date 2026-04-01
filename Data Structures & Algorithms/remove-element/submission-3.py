class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        l = 0
        r = 0
        while r != len(nums) and l != len(nums):
            while l < len(nums) and nums[l] != val:
                l+=1
            if l < len(nums):
                r = l
            while r < len(nums) and nums[r] == val:
                r+=1
            if r < len(nums) and l <len(nums):
                nums[r],nums[l] = nums[l],nums[r]
            print(nums)
        nums = nums[:l]
        return len(nums)