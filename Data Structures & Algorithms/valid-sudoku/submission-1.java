class Solution {
    private int box_id(int r,int c){
        return(r/3)*3+c/3;
    }
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 9;i++){
            for(int j = 0;j<9;j++){
                if (board[i][j] == '.') continue;
                String cur_row = board[i][j] + " @row " + i;
                String cur_col = board[i][j] + " @col "+j;
                String cur_box = board[i][j] + " @box "+box_id(i,j);
              
                if(set.contains(cur_row)||set.contains(cur_col)|| set.contains(cur_box)){
                    return false;
                }
                set.add(cur_row);
                set.add(cur_col);
                set.add(cur_box);
            }
        }
        return true;
    }
}
