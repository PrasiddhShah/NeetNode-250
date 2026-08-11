class Solution {
    int ways;
    int []memo;
    public int climbStairs(int n) {
        this.memo = new int [n+1];
        return helper(n);
        
    }
    private int helper(int n){
        if(n == 0){ 
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(memo[n] !=0){
            return memo[n];
        }
        memo[n] = helper(n-1) + helper(n-2);
        return memo[n];
    }
}
