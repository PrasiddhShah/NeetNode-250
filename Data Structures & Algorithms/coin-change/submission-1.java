class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer [][] memo = new Integer [coins.length][amount+1];
        int idx = helper(coins,0,amount,memo);
        if(idx >= Integer.MAX_VALUE -1000) return -1;
        return idx;
    }
    private int helper(int [] coins,int idx, int amount, Integer [][] memo){
        if(idx == coins.length || amount < 0){
            return Integer.MAX_VALUE -1000;
        }
        if(memo[idx][amount] != null) return memo[idx][amount];
        if(amount == 0){
            return 0;
        }

        int case1 = 1 + helper(coins,idx,amount - coins[idx], memo);
        int case0 = helper(coins,idx+1,amount,memo);
        int re = Math.min(case0,case1);
        memo[idx][amount] = re;
        return re;
    }
}
