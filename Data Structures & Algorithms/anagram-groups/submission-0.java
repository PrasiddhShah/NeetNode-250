class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> new_map = new HashMap<String,List<String>>();
        List<String> allValues = new ArrayList<>();
        for(String groupAnagram : strs){
            char tempArray[] = groupAnagram.toCharArray();
            Arrays.sort(tempArray);
            String sortedString = new String(tempArray);
            if(!new_map.containsKey(sortedString)){
                new_map.put(sortedString, new ArrayList<>());
            }
            new_map.get(sortedString).add(groupAnagram);
        }
        return new ArrayList<>(new_map.values());
    }
}
