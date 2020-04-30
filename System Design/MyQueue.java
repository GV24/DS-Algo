// Implement Queue using Stacks

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    
    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if ( stackB.isEmpty() )
        {
            if ( !stackA.isEmpty() )
            {
                while ( !stackA.isEmpty() )
                    stackB.push(stackA.pop());
                return stackB.pop();
            }
            else
                return -1;
        }
        else
            return stackB.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if ( !stackB.isEmpty() )
            return stackB.peek();
        else
        {
            if ( !stackA.isEmpty() )
            {
                while ( !stackA.isEmpty() )
                    stackB.push(stackA.pop());
                return stackB.peek();
            }
            else
                return -1;
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
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