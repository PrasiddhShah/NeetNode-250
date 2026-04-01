class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dirs = new int [][] {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> pq = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i <m; i ++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == 2){
                    pq.add( new int []{i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh ==0){
            return 0;
        }
        int count=0;
        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i=0;i<size;i++){
                int [] cur = pq.poll();
                for(int [] dir:dirs){
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if(nr >=0 && nc >=0 && nr < m && nc <n && grid[nr][nc] == 1){
                        pq.add(new int []{nr,nc});
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
            count++;
        }
        if(fresh !=0){
            return -1;
        }else{
             return --count;
        }
    }
}
