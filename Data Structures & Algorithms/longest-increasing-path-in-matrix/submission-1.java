class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, memo));
            }
        }
        return res;
    }
    private int dfs(int[][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int len = 1;
        for (int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;
            if (is_valid(matrix, newRow, newCol, row, col)) {
                len = Math.max(len, 1 + dfs(matrix, newRow, newCol, memo));
            }
        }
        memo[row][col] = len;
        return len;
    }
    private boolean is_valid(int[][] matrix, int row, int col, int oldRow, int oldCol) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length
            && matrix[row][col] > matrix[oldRow][oldCol];
    }
}
