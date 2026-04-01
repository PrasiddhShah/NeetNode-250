class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int max = 0;
        int left =0;
        int right = height.length - 1;
        int max_left = height[left];
        int max_right = height[right];
        while (left <right){
            if(max_left < max_right){
                left ++;
                max_left = Math.max(max_left,height[left]);
                max += max_left -height[left];              
            }else{
                right -= 1;
                max_right = Math.max(max_right,height[right]);
                max += max_right - height[right];   
            }

        }
        return max;
        
    }
}
