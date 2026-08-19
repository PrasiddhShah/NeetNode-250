class Solution {
    class UnionFind {
        int[] par;
        int[] rank;
        int components;
        public UnionFind(int x) {
            par = new int[x];
            rank = new int[x];
            Arrays.fill(rank, 1);
            for (int i = 0; i < x; i++) {
                par[i] = i;
            }
            components = x;
        }
        public int find(int x) {
            if (par[x] != x) {
                par[x] = find(par[x]);
            }
            return par[x];
        }
        public boolean union(int x, int y) {
            int p1 = find(x);
            int p2 = find(y);
            if (p1 == p2) {
                return false;
            }
            if (rank[p1] > rank[p2]) {
                par[p2] = p1;
                rank[p1] += rank[p2];
            } else {
                par[p1] = p2;
                rank[p2] += rank[p2];
            }
            components--;
            return true;
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.components;
    }
}
