class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n ==1){
            return nums[0];
        }
        int memo[] = new int[n];
        Arrays.fill(memo, -1);
        int start1 = helper(nums, 1, n - 1, memo);
        Arrays.fill(memo, -1);
        int start0 = helper(nums, 0, n - 2, memo);
        return Math.max(start1, start0);
    }
    private int helper(int[] nums, int idx, int end, int[] memo) {
        if (idx > end) {
            return 0;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int case0 = helper(nums, idx + 1, end, memo);
        int case1 = nums[idx] + helper(nums, idx + 2, end, memo);
        return memo[idx] = Math.max(case0, case1);
    }
}
