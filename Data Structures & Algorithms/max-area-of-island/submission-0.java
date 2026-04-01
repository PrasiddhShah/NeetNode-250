class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}}; 
        int max = 0;
        for(int i = 0; i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 2;
                    max = Math.max(max,1+dfs(grid,dirs,i,j));
                }
            }
        }
        return max;
    }
    private int dfs(int [][]grid,int [][]dirs,int i, int j){

        int area = 0;
        for(int [] dir : dirs){
            int nr = i +dir[0];
            int nc = j + dir[1];
            if(nr >=0 && nc >=0 && nr < grid.length && nc < grid[0].length &&grid[nr][nc] == 1){
                 grid[nr][nc] = 2;
                 area  += 1 + dfs(grid,dirs,nr,nc);
            }
        }
        return area;
    }
}