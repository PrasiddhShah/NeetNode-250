class Solution {
    public int rob(int[] nums) {
        int [] memo = new int [nums.length];
        for(int i = 0;i < nums.length;i++){
            memo[i] = Integer.MIN_VALUE;
        }
        return helper(nums,0,memo);
    }
    private int helper(int []nums, int idx, int [] memo){
        if (idx>=nums.length) return 0;
        if(memo[idx] != Integer.MIN_VALUE) return memo[idx];

        //base
        int case0 = helper(nums,idx+1,memo);
        int case1 =  nums[idx] + helper(nums,idx+2,memo);

        int re = Math.max(case0,case1);
        memo[idx] = re;
        return re;   
    }
}
