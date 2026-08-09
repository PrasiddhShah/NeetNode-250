class Solution {
    public String reorganizeString(String s) {
        int hash[] = new int[26];
        int max_occ = 0;
        int max_letter = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = s.charAt(i) - 'a';
            hash[l]++;
            if (hash[l] > max_occ) {
                max_occ = hash[l];
                max_letter = l;
            }
        }
        if (max_occ > (s.length()+1) / 2) {
            return "";
        }
        int idx = 0;
        char res[] = new char[s.length()];

        // filling in the max occ letter
        while(hash[max_letter]>0){
            res[idx] = (char) (max_letter + 'a');
            idx += 2;
            hash[max_letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}