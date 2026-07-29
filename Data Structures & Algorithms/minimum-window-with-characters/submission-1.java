class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> t_count = new HashMap<>();
        for(int i = 0; i< t.length();i++){
            char ch = t.charAt(i);
            t_count.put(ch,t_count.getOrDefault(ch,0)+1);
        }
        int i = 0;
        int count = t_count.size();
        String res = "";
        int min_len = Integer.MAX_VALUE;
        for(int j = 0; j < s.length();j++){
            char ch = s.charAt(j);
            if(t_count.containsKey(ch)){
                int val = t_count.get(ch);
                t_count.put(ch,--val);
                if(val ==0){
                    count--;
                }
            }
            while(count == 0){
                char old = s.charAt(i);
                if(t_count.containsKey(old)){
                    int val = t_count.get(old);
                    t_count.put(old,++val);
                    if(val > 0){
                        if(j-i+1 < min_len){
                            min_len = j-i+1;
                            res = s.substring(i,j+1);
                        }
                        count++;
                    }
                }
                i++;
            }
        }
        return res;
    }
}