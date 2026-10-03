class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }
    private void backtrack(int[] candidates, int target, int i, int total, List<Integer> cur) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (i == candidates.length || total > target) {
            return;
        }

        cur.add(candidates[i]);
        backtrack(candidates, target, i + 1, total + candidates[i], cur);
        cur.remove(cur.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        backtrack(candidates, target, i + 1, total, cur);
    }
}
