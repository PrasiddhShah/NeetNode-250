class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        boolean [] seen = new boolean[nums.length];
        helper(nums,seen,new ArrayList<>());
        return res;
    }
    private void helper(int [] nums,boolean [] seen, List<Integer> path){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }

        for(int i = 0 ; i < nums.length;i++){
            if(seen[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1]&& !seen[i-1]){
                continue;
            }
            seen[i] = true;
            path.add(nums[i]);
            helper(nums,seen,path);
            path.remove(path.size()-1);
            seen[i] = false;
        }
    }
}