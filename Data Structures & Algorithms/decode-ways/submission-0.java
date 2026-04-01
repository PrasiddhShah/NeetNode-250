class Solution {
    Integer[] memo;
    public int numDecodings(String s) {
        this.memo = new Integer[s.length()];
        int result = helper(s, 0);
        return result;
    }

    private int helper(String s, int idx) {
        //base
        if (idx == s.length()) {
            return 1;
        }
        if (s.charAt(idx) == '0')
            return 0;
        if(memo[idx] !=null){
            return memo[idx];
        }

        //logic
        int way = 0;
        //2 picks
        if (idx + 1 < s.length()) {
            int num2 = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
            if (num2 <= 26) {
                way +=helper(s, idx + 2);
            }
        }

        way +=helper(s, idx + 1);
        memo[idx] = way;
        return way;
    }

}