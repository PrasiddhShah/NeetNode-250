class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        int [] memo = new int[cost.length+1];
        
        return Math.min(helper(cost,0,memo),helper(cost,1,memo));
    }
    private int helper(int []cost,int idx,int [] memo){
        if(idx > cost.length){
            return Integer.MAX_VALUE;
        }
        if(idx == cost.length){
            return 0;
        }
        if(memo[idx]!=0){
            return memo[idx];
        }
        memo[idx] = cost[idx]+Math.min(helper(cost,idx+1,memo),helper(cost,idx+2,memo));
        return memo[idx];
    }
}
