class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        self.total = 0
        for num in nums:
            self.total +=num
        
        self.memo = [[None for _ in range(2*self.total+1)] for _ in range(len(nums)+1)]
        return self.helper(nums,0,0,target)

        
    def helper(self,nums,idx,sums,target):
        if target == sums and idx == len(nums):
            return 1
        
        if self.memo[idx][sums+self.total] != None:
            return self.memo[idx][sums+self.total]
        if idx == len(nums):
            return 0


        self.memo[idx][sums+self.total] = self.helper(nums,idx+1,sums-nums[idx],target) + self.helper(nums,idx+1,sums+nums[idx],target)
        return self.memo[idx][sums+self.total]