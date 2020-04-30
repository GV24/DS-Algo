// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

class MinStack {

    class El
    {
        int val;
        int min;
        
        El(int val, int min)
        {
            this.val = val; this.min = min;
        }
    }
    
    List<El> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int x) {
        
        int min = 0;
        if ( stack.size() > 0 )
            min = stack.get(stack.size()-1).min;
        else
            min = x;
        stack.add( new El(x, Math.min(min,x) ) );
    }
    
    public void pop() {
        
        if ( stack.size() > 0 )
            stack.remove(stack.size() - 1);
    }
    
    public int top() {
        if ( stack.size() > 0 )
            return stack.get(stack.size() - 1).val;
        return -1;
    }
    
    public int getMin() {
        if ( stack.size() > 0)
            return stack.get(stack.size() - 1).min;
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */