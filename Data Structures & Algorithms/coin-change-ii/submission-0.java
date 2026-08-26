class Solution {
    public int change(int amount, int[] coins) {
        int [][] memo = new int [amount+1][coins.length];
        return helper(amount,coins,0,memo);
    }
    private int helper(int amount,int []coins,int idx,int [][] memo){
        if(amount == 0){
            return 1;
        }
        if(idx == coins.length || amount < 0){
            return 0;
        }
        if(memo[amount][idx] !=0){
            return memo[amount][idx];
        }
        memo[amount][idx] = helper(amount,coins,idx+1,memo)+helper(amount-coins[idx],coins,idx,memo);
        return memo[amount][idx];
    }
}
