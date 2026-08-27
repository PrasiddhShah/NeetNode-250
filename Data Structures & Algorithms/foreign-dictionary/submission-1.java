class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, HashSet<Character>> map = new HashMap<>();
        int[] indegrees = new int[26];
        buildGraph(words, map, indegrees);
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : map.keySet()) {
            if (indegrees[ch - 'a'] == 0) {
                q.offer(ch);
                sb.append(ch);
            }
        }
        if (sb.length() == map.size()) {
            return sb.toString();
        }
        if (q.isEmpty() && map.size() != 0) {
            return "";
        }
        while (!q.isEmpty()) {
            char cur = q.poll();
            Set<Character> dep = map.get(cur);
            for (char free : dep) {
                indegrees[free - 'a']--;
                if (indegrees[free - 'a'] == 0) {
                    q.offer(free);
                    sb.append(free);
                    if (sb.length() == map.size()) {
                        return sb.toString();
                    }
                }
            }
        }
        if (sb.length() == map.size()) {
            return sb.toString();
        }
        return "";
    }
    private void buildGraph(
        String[] words, Map<Character, HashSet<Character>> map, int[] indegrees) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!map.containsKey(ch)) {
                    map.put(ch, new HashSet<>());
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String out = words[i];
            String in = words[i + 1];
            if(out.startsWith(in) && in.length() != out.length()){
                map.clear();
                return;
            }
            for (int j = 0; j < out.length() && j < in.length(); j++) {
                char indep = out.charAt(j);
                char dep = in.charAt(j);
                if (indep != dep) {
                    Set<Character> set = map.get(indep);
                    if (!set.contains(dep)) {
                        set.add(dep);
                        indegrees[dep - 'a']++;
                    }
                    break;
                }
            }
        }
    }
}
