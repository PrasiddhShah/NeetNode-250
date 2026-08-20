class Solution {
    private List<List<Integer>> adj;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int min = n;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int curhgt = dfs(i, -1);
            if (curhgt == min) {
                res.add(i);
            } else if (curhgt < min) {
                res = new ArrayList<>();
                res.add(i);
                min = curhgt;
            }
        }
        return res;
    }
    public int dfs(int node, int parent) {
        int hgt = 0;
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            hgt = Math.max(hgt, 1 + dfs(nei, node));
        }
        return hgt;
    }
}