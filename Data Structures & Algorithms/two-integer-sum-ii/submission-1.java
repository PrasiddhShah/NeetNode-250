class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length -1;
       int sum = 0;
       int [] ans = new int[2]; 
        System.out.println("left "+left+ " right "+right);
        while(left < right){
            sum = numbers[left] + numbers[right];
             System.out.println(sum);
             System.out.println("left "+left+ " right "+right);
            if(sum > target){
                right--;
            }
            if(sum<target){
                left++;
            }
            if(sum == target){
                break;
            }
            sum = 0;
        }
        ans[0]=left+1;
        ans[1]=right+1;
        return ans;
    }
}
