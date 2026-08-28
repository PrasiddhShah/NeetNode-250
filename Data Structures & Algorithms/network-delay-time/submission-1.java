class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, Integer> minTime = new HashMap<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        HashMap<Integer, List<List<Integer>>> graph = new HashMap<>();
        for (int[] time : times) {
            if (!graph.containsKey(time[0])) {
                graph.put(time[0], new ArrayList<>());
            }
            List<Integer> sToD = new ArrayList<>(List.of(time[1], time[2]));
            graph.get(time[0]).add(sToD);
        }
        q.offer(new int[] {0, k});
        int min_time = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            List<List<Integer>> fromS = graph.get(cur[1]);
            if (minTime.containsKey(cur[1])) {
                continue;
            }
                minTime.put(cur[1], cur[0]);
                min_time = Math.max(min_time, cur[0]);
            if (fromS != null) {
                for (List<Integer> distination : fromS) {
                    q.add(new int[] {distination.get(1) + cur[0], distination.get(0)});
                }
            }
        }
       
        return minTime.size() == n?min_time:-1;
    }
}
