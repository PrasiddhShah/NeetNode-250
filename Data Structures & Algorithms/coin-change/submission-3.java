class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        int res = helper(coins, amount, 0, memo);
        return res == Integer.MAX_VALUE - 1000 ? -1 : res;
    }
    private int helper(int[] coins, int amount, int idx, int[][] memo) {
        if (amount == 0) {
            return 0;
        }
        if (idx == coins.length || amount < 0) {
            return Integer.MAX_VALUE - 1000;
        }
        if (memo[idx][amount] != Integer.MAX_VALUE) {
            return memo[idx][amount];
        }
        int case0 = 1 + helper(coins, amount - coins[idx], idx, memo);
        int case1 = helper(coins, amount, idx + 1, memo);
        return memo[idx][amount] = Math.min(case1, case0);
    }
}
