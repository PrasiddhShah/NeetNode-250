class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][]dp = new boolean [n][n];
        int start = 0;
        int end = 0;
        for(int i = 0; i< n;i++){
            for(int j = i; j >=0;j--){
                if(s.charAt(i) == s.charAt(j) && (i-j <2 || dp[i-1][j+1])){
                    dp[i][j] = true;
                    if((i-j)>(end-start)){
                        start = j;
                        end = i;
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(start,end+1);
    }
}
