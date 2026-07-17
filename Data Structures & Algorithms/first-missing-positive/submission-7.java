class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean [] hash = new boolean[n+1];
        for(int num:nums){
            if(num >0 && n >= num){
                hash[num] = true;
            }
        }
        for(int i = 1; i < hash.length;i++){
            if(!hash[i]){
                return i;
            }
        }
        return nums.length+1;
    }
}