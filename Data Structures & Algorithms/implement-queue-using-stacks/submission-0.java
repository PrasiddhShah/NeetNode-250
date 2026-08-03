class MyQueue {
    Stack<Integer> pop_st;
    Stack<Integer> push_st;
    public MyQueue() {
        this.pop_st = new Stack<>();
        this.push_st = new Stack<>();
    }
    
    public void push(int x) {
        push_st.push(x);
    }
    
    public int pop() {
        if(!pop_st.isEmpty()){
            return pop_st.pop();
        }
        while(!push_st.isEmpty()){
            pop_st.push(push_st.pop());
        }
        return pop_st.pop();
    }
    
    public int peek() {
        if (pop_st.isEmpty()) {
            while (!push_st.isEmpty()) {
                pop_st.push(push_st.pop());
            }
        }
        return pop_st.peek();

    }
    
    public boolean empty() {
        return pop_st.isEmpty() && push_st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */