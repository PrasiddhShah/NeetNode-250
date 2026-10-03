class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<List<Integer>>> graph = new HashMap<>();
        for(int[] time:times){
            int source = time[0];
            int dest = time[1];
            int ti = time[2];
            if(!graph.containsKey(source)){
                graph.put(source,new ArrayList<>());
            }
            graph.get(source).add(new ArrayList<>(List.of(dest,ti)));
        }
        int minTime = 0;
        Map<Integer,Integer> min = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            int time = cur[1];
            int dest = cur[0];
            List<List<Integer>> pos = graph.get(cur[0]);
            if(min.containsKey(dest))continue;
            min.put(dest,time);
            minTime = Math.max(time,minTime);
            if(pos == null)continue;
            for(List<Integer> di:pos){
                pq.offer(new int []{di.get(0),time+di.get(1)});
            }
        }
        return min.size() == n?minTime:-1;
    }
}
