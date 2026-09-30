class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        int res = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                while(set.contains(ch) && j < s.length()){
                    set.remove(s.charAt(j));
                    j++;
                }
            }
            set.add(ch);
            res = Math.max(res,i-j+1);
            i++;
        }
        return res;
    }
}
