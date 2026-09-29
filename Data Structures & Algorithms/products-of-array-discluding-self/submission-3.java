class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre = 1;
        int post = 1;
        int [] res = new int [n];
        Arrays.fill(res,1);
        for (int i = 1; i < n;i++){
            pre *=nums[i-1];
            res[i] *= pre;
        }
        for(int j = n-1;j >0;j--){
            post *=nums[j];
            res[j-1] *= post;
        }
        return res;
    }
}  
