class Solution {
    public int mySqrt(int x) {
        long res = 0;
        long start = 0;
        long end = x;
        while (start <= end){
            long mid = (start+end)/2;
            if(mid*mid == x){
                return (int)mid;
            }
            if(mid*mid <x){
                start  = mid+1;
            }else{
                end = mid -1;
            }
        }
        return (int)start-1;
    }
}