class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        Boolean[][] memo = new Boolean[nums.length][(sum / 2) + 1];
        return helper(nums, 0, sum, 0, memo);
    }
    private boolean helper(int[] nums, int idx, int sum, int cur, Boolean[][] memo) {
        if (cur == sum / 2) {
            return true;
        }
        if (idx == nums.length || cur > sum / 2) {
            return false;
        }
        if (memo[idx][cur] != null) {
            return memo[idx][cur];
        }
        memo[idx][cur] = helper(nums, idx + 1, sum, cur, memo)
            || helper(nums, idx + 1, sum, cur + nums[idx], memo);
        return memo[idx][cur];
    }
}
