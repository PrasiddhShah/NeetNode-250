class MyHashSet {
    boolean arr[][];
    int bucket;
    int bucket_size;
    public MyHashSet() {
        this.bucket = 1001;
        this.bucket_size = 1000;
        this.arr = new boolean [bucket][];
    }
    private int hash1(int value){
        return value/1000;
    }
    private int hash2(int value){
        return value%1000;
    }
    
    public void add(int key) {
        int buck_loc = hash1(key);
        int buck = hash2(key);
        if(arr[buck_loc] == null){
            arr[buck_loc] = new boolean [bucket_size];
        }
        arr[buck_loc][buck] = true;
    }
    
    public void remove(int key) {
        int buck_loc = hash1(key);
        int buck = hash2(key);
        if(arr[buck_loc] == null){
            return;
        }
        arr[buck_loc][buck] = false;
        
    }
    
    public boolean contains(int key) {
        int buck_loc = hash1(key);
        int buck = hash2(key);
        if(arr[buck_loc] == null){
            return false;
        }
        return arr[buck_loc][buck];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */