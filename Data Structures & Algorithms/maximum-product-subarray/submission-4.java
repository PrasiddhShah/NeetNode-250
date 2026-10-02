class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curmin = 1;
        int curmax = 1;
        for (int num : nums) {
            if (num == 0) {
                curmin = 1;
                curmax = 1;
            }
            int tempmin = curmin * num;
            int tempmax = curmax * num;
            curmin = Math.min(Math.min(tempmin, tempmax), num);
            curmax = Math.max(Math.max(tempmin, tempmax), num);
            res = Math.max(curmax, res);
        }
        return res;
    }
}
