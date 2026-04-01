class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(),result);
        return result;
        
    }

    public void backtrack(int []nums,int pivot, List<Integer> path,List<List<Integer>>result){
        //
        if(pivot > nums.length){
            return;
        }


        //logic
        result.add(new ArrayList<>(path));
        for(int i = pivot; i < nums.length; i++){
            path.add(nums[i]);

            backtrack(nums,i+1,path,result);

            path.remove(path.size()-1);
        }
    }
}
