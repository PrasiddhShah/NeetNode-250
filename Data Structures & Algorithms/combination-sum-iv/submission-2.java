class Solution {
    public int combinationSum4(int[] nums, int target) {
        int memo[] = new int [target+1];
        Arrays.fill(memo,-1);
        return helper(nums,target,0,memo);
    }
    private int helper(int [] nums, int target,int cur_sum, int [] memo){
        if(cur_sum == target){
            return 1;
        }
        if(cur_sum > target){
            return 0;
        }
        if(memo[cur_sum] != -1){
            return memo[cur_sum];
        }
        int result =0;
        for(int num:nums){
            result +=helper(nums,target,cur_sum+num,memo);
        }
        memo[cur_sum] = result;
        return result;
    }
}