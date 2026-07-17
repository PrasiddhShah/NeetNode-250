class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int num:nums){
            hmap.put(num,hmap.getOrDefault(num,0)+1);
        }
        int thre = nums.length/3;
        for(int key:hmap.keySet()){
            if(hmap.get(key) > thre){
                res.add(key);
            }
        }
        return res;
    }
}