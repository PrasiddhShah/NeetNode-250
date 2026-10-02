class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        backtracking(nums, target, 0, 0, new ArrayList<>());
        return res;
    }
    private void backtracking(int[] nums, int target, int sum, int idx, List<Integer> path) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, target, sum + nums[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}
