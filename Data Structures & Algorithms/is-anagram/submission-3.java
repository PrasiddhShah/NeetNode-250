class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,0);
            }
            map.put(ch,map.get(ch)+1);
        }
        for(int i =0; i < t.length();i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)){
                return false;
            }
            int count =map.get(ch);
            count--;
            if(count == 0){
                map.remove(ch);
            }else{
                map.put(ch,count);
            }
        }
        return map.size() == 0;
    }
}
