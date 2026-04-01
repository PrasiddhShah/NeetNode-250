class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) {
            return 0;
        }
        quicksort(nums,0 ,nums.length-1);
        int temp = nums[0];
        int count = 1;
        int max_count=1;
        System.out.println(temp);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                continue; // skip duplicates
            } else if (nums[i] == temp + 1) {
                count++;
            } else {
                max_count = Math.max(max_count, count);
                count = 1;
            }
            temp = nums[i];
        }

        max_count = Math.max(max_count, count);
        return max_count;
    }

    private static void quicksort (int[] nums,int start, int end){
        if(end <=start) return;
        int pivot = partition(nums,start,end);
        quicksort(nums,start,pivot-1);
        quicksort(nums,pivot+1,end);
    }
    private static int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int i = start -1;
        for(int j = start; j<=end-1;j++){
            if(nums[j]<pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        i++;
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;

        return i;
    }
}
