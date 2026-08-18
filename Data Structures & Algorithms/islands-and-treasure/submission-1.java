class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int dis = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int r = dir[0] + cur[0];
                    int c = dir[1] + cur[1];
                    if (is_valid(grid, r, c)) {
                        grid[r][c] = dis;
                        q.offer(new int[] {r, c});
                    }
                }
            }
            dis++;
        }
    }
    private boolean is_valid(int[][] grid, int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && r < grid.length
            && grid[r][c] == 2147483647;
    }
}
