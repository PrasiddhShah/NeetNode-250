class Solution {
    public boolean isPalindrome(String s) {
        String lowerS = s.toLowerCase();
        char [] charS = lowerS.toCharArray();
        int left = 0;
        int right = s.length()-1;
        System.out.println(right);
        boolean ans;
        while(left < right){
            System.out.println(right+" "+left);
            System.out.println(charS[left]+ " "+charS[right]);
            if(!Character.isLetterOrDigit(charS[left]) || !Character.isLetterOrDigit(charS[right])){
                if(!Character.isLetterOrDigit(charS[left])){
                    left ++;
                }
                if(!Character.isLetterOrDigit(charS[right])){
                    right --;
                }
                continue;
            }
            if(charS[left] != charS[right])
            {
            return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
