class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character,Integer> ana1 = new HashMap<Character,Integer>();
        HashMap<Character,Integer> ana2 = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(ana1.containsKey(c))
            {
                ana1.merge(c, 1, Integer::sum);
            }
            else{
                ana1.put(c,1);
            }
        }
        for(int j = 0; j < t.length();j++){
            char c = t.charAt(j);
            if(ana2.containsKey(c))
            {
                ana2.merge(c,1,Integer::sum);
            }
            else{
                ana2.put(c,1);
            }
        }
        boolean result  = ana1.equals(ana2);
        return result;

    }
}
