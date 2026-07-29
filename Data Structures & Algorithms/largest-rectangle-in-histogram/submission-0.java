class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for(int i =0;i < heights.length;i++){
            int cur_min_height = 9999;
            for(int j = i; j < heights.length;j++){
                cur_min_height = Math.min(cur_min_height,heights[j]);
                max = Math.max(max,(cur_min_height*(j-i+1)));
            }
        }
        return max;
    }
}
