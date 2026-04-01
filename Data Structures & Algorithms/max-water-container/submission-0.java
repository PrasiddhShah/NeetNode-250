class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int max_area = 0;
        if(heights.length ==0) return 0;
        while(left < right){
            int max = Math.min(heights[left],heights[right]);
            int area = max * (right-left);
            max_area = Math.max(area,max_area);
            System.out.println(max_area+" "+area+" "+heights[left]+" "+heights[right]);
            if(heights[left] > heights[right]){
                right--;
            }else{
                left ++;
            }
        }
        return max_area;
        
    }
}
