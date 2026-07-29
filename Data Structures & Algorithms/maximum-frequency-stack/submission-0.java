class FreqStack {
    Map<Integer,Integer> cnt;
    PriorityQueue <int[]> pq;
    int index;
    public FreqStack() {
        cnt = new HashMap<>();
        pq = new PriorityQueue<>((a,b)-> a[0] != b[0]? Integer.compare(b[0],a[0]):Integer.compare(b[1],a[1]));
        index = 0;
    }
    
    public void push(int val) {
        cnt.put(val,cnt.getOrDefault(val,0)+1);
        pq.offer(new int[]{cnt.get(val),index++,val});
    }
    
    public int pop() {
        int [] top = pq.poll();
        int val = top[2];
        cnt.put(val,cnt.get(val)-1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */