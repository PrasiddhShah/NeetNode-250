class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int [][]dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] ==word.charAt(0)){
                    if(dfs(board,word,dirs,i,j,0)) return true;
                }
            }
        }
        return false;
    }
        private boolean dfs(char [][] board, String word,int [][] dirs,int r, int c,int idx){
            //
            if(idx == word.length()){
                return true;
            }
            if(r <0 || c < 0 || r >=board.length || c >=board[0].length || board[r][c] =='#'){
                return false;
            }
            //logic
            if(board[r][c] == word.charAt(idx)){

                board[r][c] = '#';
                for(int [] dir : dirs){
                    int nr = r+dir[0];
                    int nc = c+dir[1];
                    if(dfs(board,word,dirs,nr,nc,idx+1)){
                        return true;
                    }
                }
                board[r][c] = word.charAt(idx);

            }
            return false;
        }
}
