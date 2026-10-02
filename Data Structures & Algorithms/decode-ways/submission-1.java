class Solution {
    public int numDecodings(String s) {
        int memo [] = new int [s.length()+1];
        Arrays.fill(memo,-1);
        return helper(s,0,memo);
    }
    private int helper(String s,int idx,int [] memo){
        if(idx ==s.length()){
            return 1;
        }
        if(s.charAt(idx) == '0'){
            return 0;
        }
        if(memo[idx] !=-1){
            return memo[idx];
        }
        int ways =0;
        if(idx+1 <s.length()){
            int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
            if(num <=26){
                ways+= helper(s,idx+2,memo);
            }
        }
        ways+=helper(s,idx+1,memo);
        memo[idx] = ways;
        return ways;
    }
}
