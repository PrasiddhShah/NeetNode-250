class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int [nums.length];
        int sum = 1;

        for (int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < result.length; j++){
                if(j == i){
                    continue;
                }
                else{
                    sum = sum * nums[j];
                }
            }
            result[i] = sum;
            sum = 1;
        }
        return result;        
    }
}  
