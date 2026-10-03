class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indgree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int dep = pre[0];
            int indep = pre[1];
            if (!graph.containsKey(indep)) {
                graph.put(indep, new ArrayList<>());
            }
            indgree[dep]++;
            graph.get(indep).add(dep);
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indgree.length; i++) {
            if (indgree[i] == 0) {
                q.offer(i);
                numCourses--;
                res.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> avail = graph.get(cur);
            if (avail == null)
                continue;
            for (int course : avail) {
                indgree[course]--;
                if (indgree[course] == 0) {
                    res.add(course);
                    q.add(course);
                    numCourses--;
                }
            }
        }
        if (numCourses != 0) {
            return new int[0];
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
