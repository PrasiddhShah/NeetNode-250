class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    board[i][j] = 'M';
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int r, int c) {
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
            int n_r = dir[0] + r;
            int n_c = dir[1] + c;
            if (n_r >= 0 && n_c >= 0 && n_r < board.length && n_c < board[0].length
                && board[n_r][n_c] == 'O') {
                board[n_r][n_c] = 'M';
                dfs(board, n_r, n_c);
            }
        }
    }
}
