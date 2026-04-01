class Solution {
    private Integer [] memo;
    public int minCostClimbingStairs(int[] cost) {
        this.memo = new Integer[cost.length];
        int step0 = helper(cost, 0);
        int step1 = helper(cost,1);
        return Math.min(step0,step1); 
    }
    private int helper(int []cost, int steps){
        if(steps>=cost.length) return 0;
        if(memo[steps] !=null) return memo[steps];

        int oneStep = helper(cost,steps+1);
        int twoStep = helper(cost,steps+2);
        memo[steps] = cost[steps]+Math.min(oneStep,twoStep);
        return memo[steps];
    }
}