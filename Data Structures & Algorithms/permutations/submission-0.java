class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        this.result = new ArrayList<>();
        helper(nums,new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    private void helper(int [] nums, List<Integer> path, boolean []used){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length;i++){
            if(used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            helper(nums,path,used);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}