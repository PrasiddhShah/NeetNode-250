class Solution {
    public int rob(int[] nums) {
        int memo[] = new int [nums.length+1];
        Arrays.fill(memo,-1);
        return helper(nums,0,memo);
    }
    private int helper(int [] nums,int idx,int []memo){
        if(idx >=nums.length){
            return 0;
        }
        if(memo[idx] !=-1){
            return memo[idx];
        }
        int case0 = helper(nums,idx+1,memo);
        int case1 = nums[idx]+helper(nums,idx+2,memo);
        return memo[idx] = Math.max(case0,case1);
    }
}
