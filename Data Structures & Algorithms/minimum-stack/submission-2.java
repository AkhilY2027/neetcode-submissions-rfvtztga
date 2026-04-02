class MinStack {

    Stack<Integer> actualStack;
    Stack<Integer> minStack;

    public MinStack() {
        actualStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        actualStack.push(val);

        // For minStack, want the minimum at every level
        if (!minStack.isEmpty() && minStack.peek() < val) minStack.push(minStack.peek());
        else minStack.push(val);
    }
    
    public void pop() {
        actualStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return actualStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
