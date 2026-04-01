class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        hmap = dict()

        for num in nums:
            if num not in hmap:
                hmap[num] = 0
            hmap[num] = hmap[num] +1
        
        for num in nums:
            if hmap[num] > len(nums)//2:
                return num