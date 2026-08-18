class Solution {
    public int orangesRotting(int[][] grid) {
        int dis =0;
        int fresh =0;
        Queue<int[]> q = new LinkedList<>();
        int [][] dirs = new int [][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                int [] cur = q.poll();
                for(int [] dir:dirs){
                    int r = dir[0]+cur[0];
                    int c = dir[1]+cur[1];
                    if(is_valid(grid,r,c)){
                        grid[r][c] = 3;
                        fresh--;
                        q.offer(new int []{r,c});
                    }
                }
            }
            dis++;
        }
        dis--;
        if(fresh !=0){
            return -1;
        }
        return dis;
    }
    private boolean is_valid(int [][] grid,int r,int c){
        return r>=0 && c>= 0 && r<grid.length && c<grid[0].length && grid[r][c] == 1;
    }
}
