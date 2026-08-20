class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ord = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            int loc = ch - 'a';
            ord[loc] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            String firstWord = words[i];
            String secondWord = words[i + 1];
            if (notInOrder(firstWord, secondWord, ord)) {
                return false;
            }
        }
        return true;
    }
    private boolean notInOrder(String firstWord, String secondWord, int[] order) {
        for (int i = 0; i < firstWord.length() && i < secondWord.length(); i++) {
            int fchar = firstWord.charAt(i) - 'a';
            int schar = secondWord.charAt(i) - 'a';
            if (fchar != schar) {
                if (order[fchar] > order[schar]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return firstWord.length() > secondWord.length();
    }
}