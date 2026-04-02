class FreqStack {

    // Intuition: In the event of a tie, want to know the most frequent value
        // Can use a hashmap for this + Max variable
    // However, will still need to break ties

    // However, notice that when popping, the count frequency we're looking for always goes down
        // Then, need to check if previous max element is still in lead for this count as well
        // Thus, shift thinking to grouping push numbers by frequencies
    
    // First, use a HashMap to keep a track of frequencies for each number
        // Then, use a second HashMap to keep a track of orders for each count
    
    // Because of our space complexities, time is O(1) for both push and pop

    HashMap<Integer, Integer> countMap;
    int maxCount = 0;
    HashMap<Integer, Stack<Integer>> countToStack;

    public FreqStack() {
        countMap = new HashMap<>();
        countToStack = new HashMap<>();
    }
    
    public void push(int val) {
        countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        // maxCount = Math.max(countMap.get(val), maxCount);
        // countToStack.computeIfAbsent(countMap.get(val), new Stack<Integer>()).push(val);

        if (countMap.get(val) > maxCount) {
            maxCount = countMap.get(val);
            countToStack.putIfAbsent(maxCount, new Stack<>());
        }
        countToStack.get(countMap.get(val)).push(val);
    }
    
    public int pop() {
        // Go through this layer by layer
            // We know from maxCount there is at least 1 element on that layer
                // Plus, if we decrement maxCount, then it is also guarenteed for another element on that layer
        if (maxCount == 0) return -1;

        int sol = countToStack.get(maxCount).pop();
        countMap.put(sol, countMap.get(sol) - 1);
        if (countToStack.get(maxCount).isEmpty()) maxCount--;
        return sol;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */