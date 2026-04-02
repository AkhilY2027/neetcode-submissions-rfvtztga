class MyStack {

    // Already know a way we can use a queue to make stack with O(n) time
        // Instead, want O(1) time for all operations

    // Instead, do a "queue of queues"
        // Will simulate a stack's elements by having each queue take on the properties of a linkedlist node in and of themselves

    private Queue<Object> masterQ;

    public MyStack() {
        masterQ = null;
    }
    
    public void push(int x) {
        Queue<Object> q = new LinkedList<>();
        q.add(x);
        q.add(masterQ);
        masterQ = q;
    }
    
    public int pop() {
        if (masterQ == null)
            return -1;
        
        int sol = (int) masterQ.poll();
        masterQ = (Queue<Object>) masterQ.poll();
        return sol;
    }
    
    public int top() {
        if (masterQ == null)
            return -1;
        return (int) masterQ.peek();
    }
    
    public boolean empty() {
        return masterQ == null;
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