class Solution {
    class UnionFind{
        int[] par;
        int []rank;
        public UnionFind(int n){
            this.par = new int[n];
            this.rank = new int [n];
            Arrays.fill(rank,1);
            for(int i = 0 ;i<n;i++){
                par[i] = i;
            }
        }
        public int find(int x){
            if(par[x]!=x){
                par[x] = find(par[x]);
            }
            return par[x];
        }
        public boolean union(int x,int y){
            int p1 = find(x);
            int p2 = find(y);
            if(p1 == p2){
                return false;
            }
            if(rank[p1]>rank[p2]){
                par[p2] = p1;
                rank[p1]+=rank[p2];
            }else{
            par[p1] = p2;
            rank[p2]+=rank[p1];
            }
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String,Integer> emailToIdx = new HashMap<>(); // email to account idx

        for(int i = 0;i<accounts.size();i++){
            List<String> account = accounts.get(i);
            for(int j = 1;j < account.size();j++){
                String email = account.get(j);
                if(emailToIdx.containsKey(email)){
                    uf.union(i,emailToIdx.get(email));
                }else{
                    emailToIdx.put(email,i);
                }
            }
        }
        Map<Integer,List<String>> emailGroup = new HashMap<>();
        for(String email:emailToIdx.keySet()){
            int idx  = emailToIdx.get(email);
            int lead = uf.find(idx);
            if(!emailGroup.containsKey(lead)){
                emailGroup.put(lead,new ArrayList<>());
            } 
                emailGroup.get(lead).add(email);
        }
        List<List<String>> res = new ArrayList<>();
        for(int idx:emailGroup.keySet()){
            List<String> emails = emailGroup.get(idx);
            String name = accounts.get(idx).get(0);
            Collections.sort(emails);
            emails.add(0,name);
            res.add(emails);
        }
        return res;
    }
}