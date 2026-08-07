class Solution {
    HashMap<Character, String> map;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }
    private void backtrack(String digits, int idx, StringBuilder sb, List<String> res) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letter = map.get(digits.charAt(idx));
        for (char c : letter.toCharArray()) {
            sb.append(c);
            backtrack(digits, idx + 1, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }
}
