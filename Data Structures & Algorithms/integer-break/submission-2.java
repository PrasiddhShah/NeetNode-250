class Solution {
    int n;
    public int integerBreak(int n) {
        this.n = n;
        int [] memo = new int [n+1];
        Arrays.fill(memo,-1);
        return dfs(n,memo);
    }
    private int dfs(int num, int [] memo){
        if(memo[num] !=-1){
            return memo[num];
        }
        if(num == n){
            memo[num] = 0;
        }else{
            memo[num] = num;
        }
        for(int i = 1; i < num;i++){
            int val = dfs(i,memo)*dfs(num-i,memo);
            memo[num] = Math.max(memo[num],val);
        }
        return memo[num];
    }
}