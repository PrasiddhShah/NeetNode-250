class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
         List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;       
    }
    private void helper(int[] candidates, int pivot, int target, List<Integer> path, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        if (target < 0 || pivot == candidates.length) {

            return;
        }

        for (int i = pivot; i < candidates.length; i++) {
            if(i > pivot && candidates[i-1] == candidates[i]) continue;
            path.add(candidates[i]);
            helper(candidates, i+1, target - candidates[i], path, result);

            path.remove(path.size() - 1);
        }
    }
}
