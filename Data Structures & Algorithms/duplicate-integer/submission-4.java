class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set_nums = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(set_nums.contains(nums[i]))
            {
                return true;
            }
            set_nums.add(nums[i]);
        }
        return false;
    }
}
