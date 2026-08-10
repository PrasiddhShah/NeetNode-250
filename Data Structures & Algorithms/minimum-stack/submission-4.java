class MinStack {
    Stack<Integer> st;
    Stack<Integer> min_st;
    public MinStack() {
        st = new Stack<>();
        min_st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min_st.isEmpty() || min_st.peek()>=val){
            min_st.push(val);
        }
    }
    
    public void pop() {
        int val = st.pop();
        if(val == min_st.peek()){
            min_st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        if(min_st.isEmpty()){
            return 0;
        }
        return min_st.peek();
    }
}
