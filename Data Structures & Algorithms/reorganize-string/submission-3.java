class Solution {
    public String reorganizeString(String s) {
        int [] hash = new int[26];
        int max_occr = 0;
        int max_letter = 0;
        for(int i = 0; i < s.length();i++){
            int ch_loc = s.charAt(i) - 'a';
            hash[ch_loc]++;
            if(hash[ch_loc] > max_occr){
                max_letter = ch_loc;
                max_occr = hash[ch_loc];
            }
        }
        if(max_occr > (s.length()+1)/2){
            return "";
        }
        int idx = 0;
        char []res = new char [s.length()];
        // fill the char that occured the max times
        while(hash[max_letter]>0){
            res[idx] = (char)(max_letter+'a');
            hash[max_letter]--;
            idx+=2;
        }

        //fill the rest
        for(int  i=0;i<hash.length;i++){
            while(hash[i] > 0){
                if(idx >= res.length){
                    idx = 1;
                }
                res[idx] = (char)(i+'a');
                idx+=2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}