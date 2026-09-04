class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int curInt = nums[0];
        int nextInt = nums[0];
        int jump = 1;
        for (int i = 1; i < n; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if (i == curInt) {
                if (i != n - 1) {
                    jump++;
                    curInt = nextInt;
                }
            }
        }
        return jump;
    }
}
