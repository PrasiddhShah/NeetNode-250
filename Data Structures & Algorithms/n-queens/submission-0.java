class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean [][] board = new boolean [n][n];
        backtrack(board, 0, result);
        return result;
        
    }
    private void backtrack(boolean [][]board,int r,List<List<String>> result){
        //base
        if( r== board.length){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board[0].length;j++){
                    if(board[i][j] == true){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(new ArrayList<>(li));
        }

        //logic
        for(int c = 0; c < board.length; c++){
            if(isSafe(board,r,c)){
                //action
                board[r][c] = true;

                //recurse
                backtrack(board,r+1,result);

                //backtrack
                board[r][c] = false;
            }
        }
    }


    private boolean isSafe(boolean [][]board, int r, int c){
        //row up check
        for(int i = r-1; i>=0; i--){
            if(board[i][c] == true){
                return false;
            }
        }
        // diagonal left check
        int i = r;
        int j = c; 
        while(i >=0 && j >=0){
            if(board[i--][j--] == true) return false;
        }

        // diagonal right check
        i = r;
        j = c; 
        while(i >=0 && j <board[0].length){
            if(board[i--][j++] == true) return false;
        }
        return true;
    }
}
