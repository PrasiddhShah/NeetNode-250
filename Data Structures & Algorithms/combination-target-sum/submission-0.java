class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,target,0,new ArrayList<>(),result);
        return result;
        
    }
    private void helper(int []nums,int target, int idx, List<Integer> path, List<List<Integer>> result){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || idx == nums.length){
            return;
        }

        //
        //dont choose
        helper(nums,target,idx+1,path,result);

        //choose
        path.add(nums[idx]);
        helper(nums,target-nums[idx],idx,path,result);

        //backtrack
        path.remove(path.size()- 1);
        

    }
}
