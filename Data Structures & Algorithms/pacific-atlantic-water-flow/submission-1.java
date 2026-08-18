class Solution {
    private static final int[][] DIRS = {{0,1},{1,0},{-1,0},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        Queue<int[]> pq = new LinkedList<>(), aq = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pac[i][0] = true;      pq.offer(new int[]{i, 0});
            atl[i][n-1] = true;    aq.offer(new int[]{i, n-1});
        }
        for (int j = 0; j < n; j++) {
            pac[0][j] = true;      pq.offer(new int[]{0, j});
            atl[m-1][j] = true;    aq.offer(new int[]{m-1, j});
        }

        bfs(heights, pq, pac);
        bfs(heights, aq, atl);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pac[i][j] && atl[i][j]) res.add(List.of(i, j));
        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] seen) {
        int m = heights.length, n = heights[0].length;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : DIRS) {
                int r = cur[0] + d[0], c = cur[1] + d[1];
                if (r >= 0 && c >= 0 && r < m && c < n && !seen[r][c]
                        && heights[r][c] >= heights[cur[0]][cur[1]]) {
                    seen[r][c] = true;
                    q.offer(new int[]{r, c});
                }
            }
        }
    }
}