// Implement Stack using Queues

class MyStack {

    /** Initialize your data structure here. */
    ArrayDeque<Integer> q;
    
    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = q.size();
        int ret = -1;
        
        if ( q.isEmpty() )
            return -1;
        
        if ( size > 1 )
            for ( int i = 0; i < size - 1; ++i )
                q.add(q.pollFirst());
        ret = q.pollFirst();
        return ret;
    }
    
    /** Get the top element. */
    public int top() {
        
        int size = q.size();
        int ret = -1;
        
        if ( q.isEmpty() )
            return -1; 
        
        if ( size > 1 )
            for ( int i = 0; i < size - 1; ++i )
                q.add(q.pollFirst());
        ret = q.pollFirst();
        q.add(ret);
        return ret;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */