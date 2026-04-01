class LRUCache {
    class ListNode{
        int key;
        int value;
        ListNode next;
        ListNode prev;
        public ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private ListNode head;
    private ListNode tail; 
    private int capacity;  
    private HashMap<Integer,ListNode> Hmap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode(-1,-1);
        this.tail = new ListNode(-1,-1);
        Hmap = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    private void removeNode(ListNode root){
        root.prev.next = root.next;
        root.next.prev = root.prev;
    }
    private void addToHead(ListNode root){
        root.next = head.next;
        head.next.prev = root;
        head.next = root;
        root.prev = head;

    }
    
    public int get(int key) {
        if(Hmap.containsKey(key)){
            ListNode cur = Hmap.get(key);
            removeNode(cur);
            addToHead(cur);
            return cur.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(Hmap.containsKey(key)){
            ListNode node = Hmap.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        }else{
            if(Hmap.size() == capacity){
                ListNode tailPre = tail.prev;
                removeNode(tailPre);
                Hmap.remove(tailPre.key);
                tailPre.next = null;
                tailPre.prev = null;
            }
            ListNode newNode = new ListNode(key,value);
            addToHead(newNode);
            Hmap.put(key,newNode);
        }
    }
}
