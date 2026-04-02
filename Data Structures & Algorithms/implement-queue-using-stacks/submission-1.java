class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        // // Naive: Reverse order of stack by popping to second stack
        // while (!stack1.isEmpty())
        //     stack2.push(stack1.pop());
        
        // // Then, pop out the first of stack2
        // int sol = stack2.pop();

        // // Reset
        // while (!stack2.isEmpty())
        //     stack1.push(stack2.pop());
        // return sol;

        // Better solution: Designate stack2 as the official "pop" stack
            // Currently, we reverse stack1 via stack2, find the pop, and then reverse stack2 via stack1
            // However, there isn't a need to reverse stack2 again as our push function doesn't need to know what elements are in stack1
            // Thus, keep elements in stack2 as is – reverse stack1 into stack2 if stack2 is empty
                // This way, O(1) on average (amortized)
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        
        return stack2.pop();
    }
    
    public int peek() {
        // // Naive: Reverse order of stack by popping to second stack
        // while (!stack1.isEmpty())
        //     stack2.push(stack1.pop());
        
        // // Then, pop out the first of stack2
        // int sol = stack2.peek();

        // // Reset
        // while (!stack2.isEmpty())
        //     stack1.push(stack2.pop());
        // return sol;

        // Optimization: Again, do the same thing as above for an amortized O(1)
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
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