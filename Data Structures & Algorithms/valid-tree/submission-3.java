class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        int[] head = new int[n];
        for (int i = 0; i < head.length; i++) {
            head[i] = i;
        }
        for (int[] edge : edges) {
            int px = find(edge[0], head);
            int py = find(edge[1], head);
            if (px == py) {
                return false;
            }
            head[px] = py;
        }
        return true;
    }
    private int find(int x, int[] head) {
        if (head[x] != x) {
            head[x] = find(head[x], head);
        }
        return head[x];
    }
}
