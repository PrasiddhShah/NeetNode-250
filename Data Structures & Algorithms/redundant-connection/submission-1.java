class Solution {
    class unionFind {
        int[] par;
        int[] rank;
        public unionFind(int n) {
            this.par = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
            Arrays.fill(rank, 1);
        }
        public int find(int x) {
            if (par[x] != x) {
                par[x] = find(par[x]);
            }
            return par[x];
        }
        public boolean union(int x, int y) {
            int py = find(y);
            int px = find(x);
            if (px == py) {
                return true;
            }
            if (rank[py] > rank[px]) {
                rank[py] += rank[px];
                par[px] = py;
            } else {
                rank[px] += rank[py];
                par[py] = px;
            }
            return false;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        unionFind uf = new unionFind(edges.length + 1);
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                return new int[] {edge[0], edge[1]};
            }
        }
        return new int[] {-1, -1};
    }
}
