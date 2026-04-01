class Solution {
    public int numIslands(char[][] grid) {
        int [][] dirs ={{0,1},{1,0},{0,-1},{-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == '1'){
                   count++;
                   dfs(grid, i, j, dirs);
                }
            }
        }
        return count;
    }
    private void dfs(char [][] grid, int i, int j, int dirs[][]){
        //base
        if( i < 0 || j < 0 || i ==grid.length || j == grid[0].length || grid[i][j] == '0') return;

        //logic
        grid[i][j] = '0';
        for(int [] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            dfs(grid,nr,nc,dirs);
        }

    }
}