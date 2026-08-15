class Solution {
    public int numSquares(int n) {
        for (int limit = 1; limit < 5; limit++) {
            if (dls(n, limit)) {
                return limit;
            }
        }
        return 4;
    }
    private boolean dls(int target, int depth) {
        if (depth == 0) {
            return target == 0;
        }
        int root = (int) Math.sqrt(target);
        for (int i = root; i >= 1; i--) {
            if (dls(target - i * i, depth - 1)) {
                return true;
            }
        }
        return false;
    }
}