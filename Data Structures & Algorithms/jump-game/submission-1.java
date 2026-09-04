class Solution {
    int memo [];
    public boolean canJump(int[] nums) {
        memo = new int [nums.length];
        Arrays.fill(memo,-1);
        return helper(nums,0);
    }
    private boolean helper(int []nums,int idx){
        if(idx == nums.length-1){
            return true;
        }
        if(idx >=nums.length){
            return false;
        }
        if (memo[idx] !=-1){
            return memo[idx] == 1? true:false;
        }
        int curStep = nums[idx];
        if(curStep == 0){
            return false;
        }
        boolean res = false;
        for(int i = 1; i<=curStep;i++){
            res = res || helper(nums,idx+i);
        }
        memo[idx] = res == true?1:2;
        return res;
    }
}
