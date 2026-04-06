class StockSpanner {

    // Is this not just a binary search through a sorted array?
        // The index corresponds to how many stocks are less than/equal to this one
        // DOES NOT WORK – Spans need to be consecutive
    
    // Even better optimization: Use repeated work
        // Upon a price, check previous element – If lesser, than we subsume its span into our own span
            // And since a span is consecutive lower days, we can "jump" that amount in our linear search
            // This ends when we get to an element that is greater than our own
        // However, by itself, this optimization is still O(n^2)
        // But realize, that once we calculate the current price's span, we don't need the spans of our "jumps"
            // Again, spans are consecutive, so if next price is lower, it is halted by current price, and if higher, our current price has already done the work
        // Because of this addition and removal, we are using a stack data structure
            // Solution is known as a Monotonic Decreasing Stack
            // Because each number is added/removed at most once, solution is O(n) time and space
    
    Stack<int[]> spans;

    public StockSpanner() {
         spans = new Stack<>();
    }
    
    public int next(int price) {
        // We check the spans within the stack until we get to a span that does not work
        int curSpan = 1; // Includes itself
        while (!spans.isEmpty() && spans.peek()[0] <= price)
            curSpan += spans.pop()[1];
        spans.add(new int[] {price, curSpan});
        return curSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */