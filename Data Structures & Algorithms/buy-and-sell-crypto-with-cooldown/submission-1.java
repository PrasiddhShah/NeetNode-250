class Solution {
    int [][]memo;
    public int maxProfit(int[] prices) {
        this.memo = new int [prices.length][2];
        return helper(prices,0,false);
    }
    private int helper(int [] prices,int i,boolean flag){
        if(i >= prices.length){
            return 0;
        }
        if(flag){
            if(memo[i][1] !=0){
                return memo[i][1];
            }
        }
        if(!flag){
            if(memo[i][0] !=0){
                return memo[i][0];
            }
        }

        if(!flag){
            //buy
            int case1 = helper(prices,i+1,true) -prices[i];

            // no buy
            int case2 = helper(prices,i+1,false);
            memo[i][0] = Math.max(case1,case2);
            return memo[i][0];
        }else{
            //sell
            int case1 = helper(prices,i+2,false) + prices[i];

            //no sell
            int case2 = helper(prices,i+1,true);
            memo[i][1] = Math.max(case1,case2);
            return memo[i][1];
        }
    }
}