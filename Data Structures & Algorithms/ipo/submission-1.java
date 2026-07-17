class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int []> minCap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<int []> maxProfit = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int i = 0 ; i < profits.length;i++){
            minCap.add(new int []{capital[i],profits[i]});
        }
        int res = 0;
        while(k > 0){
            while(!minCap.isEmpty() && minCap.peek()[0] <= w){
                maxProfit.add(minCap.poll());
            }
            if(maxProfit.isEmpty()){
                return w;
            }           
            int[] cur = maxProfit.poll();
            w += cur[1];
            k--;
        }
        return w;

    }
}