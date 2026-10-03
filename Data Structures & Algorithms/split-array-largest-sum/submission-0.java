class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(mid, nums, k)) {
                result = mid;
                right = mid - 1;
                
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    private boolean canSplit(int max, int[] nums, int k) {
        int subArray = 0;
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum > max) {
                subArray++;
                curSum = num;
            }
        }
        return subArray + 1 <= k;
    }
}