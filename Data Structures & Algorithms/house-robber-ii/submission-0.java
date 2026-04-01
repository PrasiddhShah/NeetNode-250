class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 0) {
            return 0;
        }
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = Integer.MIN_VALUE + 1000;
        }
        int start1 = dfs(nums, 1, n - 1, memo);
        for (int i = 0; i < n; i++) {
            memo[i] = Integer.MIN_VALUE + 1000;
        }
        int start0 = dfs(nums, 0, n - 2, memo);
        return Math.max(start1, start0);
    }

    private int dfs(int[] nums, int idx, int end, int[] memo) {
        if (idx > end) {
            return 0;
        }
        if (memo[idx] != Integer.MIN_VALUE + 1000) {
            return memo[idx];
        }

        int skip = dfs(nums, idx + 1, end, memo);
        int rob = nums[idx] + dfs(nums, idx + 2, end, memo);
        int re = Math.max(skip, rob);
        memo[idx] = re;
        return re;
    }
}