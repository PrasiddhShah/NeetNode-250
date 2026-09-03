class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int rsum = Integer.MIN_VALUE + 10000;
        int sum = Integer.MAX_VALUE+10000;
        for(int i = 0; i < nums.length;i++){
            rsum = Math.max(nums[i],nums[i]+rsum);
            sum = Math.max(sum,rsum);
        }
        return sum;
    }
}
