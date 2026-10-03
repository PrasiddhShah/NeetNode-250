class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tmp = dist.clone();          // read from last round only
            for (int[] f : flights) {
                if (dist[f[0]] == Integer.MAX_VALUE) continue;
                tmp[f[1]] = Math.min(tmp[f[1]], dist[f[0]] + f[2]);
            }
            dist = tmp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}