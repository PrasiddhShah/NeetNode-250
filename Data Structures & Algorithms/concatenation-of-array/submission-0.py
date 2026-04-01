class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [None]*n* 2

        for i in range(n):
            res[i] = nums[i]
            res[i+n] = nums[i]
        return res