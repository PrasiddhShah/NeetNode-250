class Solution {
    public int removeDuplicates(int[] nums) {
        int writer = 0;
        int seeker = 0;
        
        while(seeker < nums.length){
            if (seeker ==0 ||nums[seeker-1] != nums[seeker]){
                nums[writer] = nums[seeker];
                writer++;
                
            }
                seeker++;
        
            
        }
        return writer;
    }
}