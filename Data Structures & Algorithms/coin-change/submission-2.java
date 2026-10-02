class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = helper(coins, amount, 0);
        return res == Integer.MAX_VALUE - 1000 ? -1 : res;
    }
    private int helper(int[] coins, int amount, int idx) {
        if (amount == 0) {
            return 0;
        }
        if (idx == coins.length || amount < 0) {
            return Integer.MAX_VALUE - 1000;
        }

        int case0 = 1 + helper(coins, amount - coins[idx], idx);
        int case1 = helper(coins, amount, idx + 1);
        return Math.min(case1, case0);
    }
}
