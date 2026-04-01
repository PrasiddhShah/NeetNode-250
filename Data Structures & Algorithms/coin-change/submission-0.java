class Solution {
    public int coinChange(int[] coins, int amount) {
        int idx = helper(coins,0,amount);
        if(idx >= Integer.MAX_VALUE -1000) return -1;
        return idx;
    }
    private int helper(int [] coins,int idx, int amount){
        if(idx == coins.length || amount < 0){
            return Integer.MAX_VALUE -1000;
        }
        if(amount == 0){
            return 0;
        }

        int case1 = 1 + helper(coins,idx,amount - coins[idx]);
        int case0 = helper(coins,idx+1,amount);
        return Math.min(case1,case0);
    }
}
