class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] ind = new int [numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int [] pre:prerequisites){
            if(!map.containsKey(pre[1])){
                map.put(pre[1],new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
            ind[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < ind.length;i++){
            if(ind[i] == 0){
                q.offer(i);
                res.add(i);
                numCourses--;
            }
        }
              
        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> open = map.get(cur);
            if(open == null){
                continue;
            }
            for(int course:open){
                ind[course]--;
                if(ind[course]==0){
                    numCourses--;
                    q.offer(course);
                    res.add(course);
                }
            }
        }
        if(numCourses != 0){
            return new int [0];
        }
        int [] f = new int [res.size()];
        for(int i=  0;i< f.length;i++){
            f[i] = res.get(i);
        }
        return f;
    }
}
