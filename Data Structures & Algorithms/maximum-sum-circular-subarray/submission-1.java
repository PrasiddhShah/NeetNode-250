class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0;
        int curMin = 0;
        int minSum = nums[0];
        int maxSum = nums[0];
        int total = 0;
        for (int num : nums) {
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(curMax, maxSum);
            curMin = Math.min(num, curMin + num);
            minSum = Math.min(curMin, minSum);
            total += num;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}