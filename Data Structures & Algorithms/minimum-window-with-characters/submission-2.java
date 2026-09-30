class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> t_map = new HashMap<>();
        for(int i = 0 ; i < t.length();i++){
            char ch = t.charAt(i);
            t_map.put(ch,t_map.getOrDefault(ch,0)+1);
        }
        int count = t_map.size();
        int i = 0;
        String res = "";
        int min_len = s.length()+1;
        for(int j =  0; j < s.length();j++){
            char cur = s.charAt(j);
            if(t_map.containsKey(cur)){
                int val = t_map.get(cur);
                t_map.put(cur,--val);
                if(val ==0){
                    count--;
                }
            }
            while(count == 0){
                char old_ch = s.charAt(i);
                if(t_map.containsKey(old_ch)){
                    int val = t_map.get(old_ch);
                    t_map.put(old_ch,++val);
                    if(val > 0){
                        if((j-i+1) < min_len){
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
