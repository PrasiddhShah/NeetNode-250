class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indgrees = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            if (!graph.containsKey(pre[1])) {
                graph.put(pre[1], new ArrayList<>());
            }
            graph.get(pre[1]).add(pre[0]);
            indgrees[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indgrees.length; i++) {
            if (indgrees[i] == 0) {
                q.offer(i);
                numCourses--;
            }
        }
        if (numCourses == 0) {
            return true;
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> openCourses = graph.get(cur);
            if(openCourses == null){
                continue;
            }
            for (int openCourse : openCourses) {
                indgrees[openCourse]--;
                if (indgrees[openCourse] == 0) {
                    numCourses--;
                    q.add(openCourse);
                }
            }
            
            graph.remove(cur);
        }
        return numCourses == 0;
    }
}
