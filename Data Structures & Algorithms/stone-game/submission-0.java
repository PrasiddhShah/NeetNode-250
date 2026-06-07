class Solution {
    public boolean stoneGame(int[] piles) {
       int n = piles.length;
       int [][] memo = new int [n][n];
       int dif = helper(piles,0,n-1,memo);
       return dif > 0;
    }
    private int helper(int [] piles, int start, int end, int [][]memo){
        if(start > end){
            return 0;
        }
        if(memo[start][end] != 0){
            return memo[start][end];
        }
        int left = piles[start] - helper(piles,start+1,end,memo);
        int right = piles[end] - helper(piles,start,end - 1,memo);
        memo[start][end] = Math.max(left,right);
        return memo[start][end];
    }
}