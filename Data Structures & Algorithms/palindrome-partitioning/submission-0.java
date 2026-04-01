class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s,0,new ArrayList<>(),result);
        return result;
    }
    private void helper(String s,int pivot, List<String>path,List<List<String>> result){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        //logic
        for(int i = pivot; i < s.length(); i++){
            String cur = s.substring(pivot,i+1);
            if(ispalindrome(cur)){
                path.add(cur);

                helper(s,i+1,path,result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean ispalindrome(String s){
        int i =0;
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i++) != s.charAt(j--))return false;
        }
        return true;
    }
}
