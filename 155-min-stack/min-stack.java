class MinStack {
    //val,minval

    public Stack<Pair<Integer,Integer>> stk;
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if(stk.isEmpty()){
            stk.push(new Pair<>(val,val));
        }
        else{
            int minVal =Math.min(val,stk.peek().getValue());
            stk.push(new Pair<>(val,minVal));
        }
    }
    
    public void pop() {
        if(!stk.isEmpty()){
            stk.pop();
        }
    }
    
    public int top() {
        if(!stk.isEmpty()){
            int topp = stk.peek().getKey();
            return topp;
        }
        return -1;
    }
    
    public int getMin() {
        if(!stk.isEmpty()){
            return stk.peek().getValue();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */