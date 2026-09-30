class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            if ((mid == 0 || nums[mid - 1] > nums[mid])
                && (mid == nums.length - 1 || nums[mid + 1] > nums[mid])) {
                return nums[mid];
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
