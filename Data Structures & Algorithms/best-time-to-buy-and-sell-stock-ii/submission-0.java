class Solution {
    public int maxProfit(int[] prices) {
        int total_profit = 0;
        int buy = prices[0];
        for(int i = 1;i<prices.length;i++){
            if (prices[i] - buy > 0){
                total_profit += prices[i] - buy;
            }
            buy = prices[i];
        }
        return total_profit;
    }
}