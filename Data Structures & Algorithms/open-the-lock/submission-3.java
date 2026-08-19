class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> seen = new HashSet<>();
        if (dead.contains("0000"))
            return -1;
        if (target.equals("0000"))
            return 0;
        Queue<String> q = new LinkedList<>();
        seen.add("0000");
        q.offer("0000");
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return res;
                }
                for (int j = 0; j < cur.length(); j++) {
                    char[] arr = cur.toCharArray();
                    int val = arr[j] - '0';
                    arr[j] = (char) ('0' + (val + 1) % 10);
                    String up = new String(arr);
                    if (!dead.contains(up) && seen.add(up)) {
                        seen.add(up);
                        q.offer(up);
                    }
                    arr[j] = (char) ('0' + (val + 9) % 10);
                    String down = new String(arr);
                    if (!dead.contains(down) && seen.add(down)) {
                        q.offer(down);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}