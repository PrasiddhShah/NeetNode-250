class TimeStamped{
    public int timestamp;
    public String value;

    public TimeStamped(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {
    Map<String, ArrayList<TimeStamped>> entiresByValue;
    public TimeMap() {
        entiresByValue = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!entiresByValue.containsKey(key)){
            entiresByValue.put(key, new ArrayList<>());
        }
        ArrayList<TimeStamped> tmv = entiresByValue.get(key);
        tmv.add(new TimeStamped(timestamp,value));
        
    }
    
    public String get(String key, int timestamp) {
        if(!entiresByValue.containsKey(key)){
            return "";
        }
        ArrayList<TimeStamped> tmv = entiresByValue.get(key);
        Optional<TimeStamped> timeStamp = bstv(tmv,timestamp);
        if(timeStamp.isEmpty()){
            return "";
        }
        return timeStamp.get().value;
        
    }
    private Optional<TimeStamped> bstv(ArrayList<TimeStamped>arr, int target){
        int left = 0;
        int right = arr.size()-1;
        int matchIndex = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            TimeStamped cur = arr.get(mid);
            if(cur.timestamp <=target){
                matchIndex = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(matchIndex == -1){
            return Optional.empty();
        }
        return Optional.of(arr.get(matchIndex));
    }
}
