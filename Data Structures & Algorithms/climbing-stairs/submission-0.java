class Solution {
    int [] memo;
    public int climbStairs(int n) {
        this.memo = new int[n];
        return helper(0,n);       
    }
    private int helper(int steps, int n){
        //base
        if(steps >n) return 0;
        if(steps == n) return 1;
        if(memo[steps] !=0) return memo[steps]; 
        //logic
        int re = helper(steps+1,n) + helper(steps+2,n);
        memo[steps] = re;
        return re;
    }
}