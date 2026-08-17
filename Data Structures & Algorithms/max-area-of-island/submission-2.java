class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    area = Math.max(area, 1 + dfs(grid, dirs, i, j));
                }
            }
        }
        return area;
    }
    private int dfs(int[][] grid, int[][] dirs, int row, int col) {
        int area = 0;
        for (int[] dir : dirs) {
            int n_r = row + dir[0];
            int n_c = col + dir[1];
            if (is_valid(grid, n_r, n_c)) {
                grid[n_r][n_c] = 2;
                area += 1 + dfs(grid, dirs, n_r, n_c);
            }
        }
        return area;
    }
    private boolean is_valid(int[][] grid, int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] != 0
            && grid[r][c] != 2;
    }
}
