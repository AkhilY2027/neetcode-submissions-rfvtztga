class MinStack {

    // Want: to save order of pushes + keep a track of the min element
        // Priority Queue is logn so cannot use
    
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        min.push(Math.min(val, min.isEmpty() ? Integer.MAX_VALUE : min.peek()));
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
