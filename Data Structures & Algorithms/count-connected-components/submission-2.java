class Solution {
    class UnionFind {
        int components;
        int[] par;
        int[] rank;
        public UnionFind(int n){
            rank = new int[n];
            par = new int[n];
            Arrays.fill(rank, 1);
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
            components = n;
        }
        private int find(int x) {
            if (par[x] != x) {
                par[x] = find(par[x]);
            }
            return par[x];
        }
        private boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return false;
            }
            if (rank[px] > rank[py]) {
                rank[px] += rank[py];
                par[py] = px;
            } else {
                rank[py] += rank[px];
                par[px] = py;
            }
            components--;
            return true;
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uv = new UnionFind(n);
        for (int[] edge : edges) {
            uv.union(edge[0], edge[1]);
        }
        return uv.components;
    }
}
