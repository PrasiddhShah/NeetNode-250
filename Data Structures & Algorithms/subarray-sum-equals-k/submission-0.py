class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if len(nums) == 0:
            return 0
        totalArr = 0
        rsum = 0
        hmap = dict()
        hmap[0] = 1
        for num in nums:
            rsum+=num
            if hmap.get(rsum-k):
                totalArr += hmap.get(rsum-k)
            if hmap.get(rsum):
                hmap[rsum] +=1
            else:
                hmap[rsum] = 1
        return totalArr