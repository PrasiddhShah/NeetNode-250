class Solution {
    public int findDuplicate(int[] nums) {
        int result=0;
        for(int i = 0; i < nums.length;i++){
            if(nums[Math.abs(nums[i]) - 1] < 0){
                result = Math.abs(nums[i]);
                break;
            }else{
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        } 
       return result;
    }
}
