class MedianFinder {

    // Separate stream into 2 pqs – keep track of largest small number and smallest large number
    PriorityQueue<Integer> smallPQ;
    PriorityQueue<Integer> bigPQ;

    public MedianFinder() {
        smallPQ = new PriorityQueue<>(Collections.reverseOrder());
        bigPQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Rules of pqs:
            // Should always add num to smallest heap first
            // Then, check if nums of smallPQ are lesser than bigPQ – if not, shift
            // After, check if lengths are same – if not, shift
        smallPQ.add(num);
        if ((!bigPQ.isEmpty() && smallPQ.peek() > bigPQ.peek())
            || smallPQ.size() - bigPQ.size() > 1)
            bigPQ.add(smallPQ.poll()); // Add if nums are lesser / lengths aren't the same
        if (bigPQ.size() - smallPQ.size() > 1) smallPQ.add(bigPQ.poll()); // Add if lengths aren't the same
    }
    
    public double findMedian() {
        if (bigPQ.size() == smallPQ.size()) return (double) (bigPQ.peek() + smallPQ.peek()) / 2;
        else if (bigPQ.size() > smallPQ.size()) return (double) bigPQ.peek();
        else return (double) smallPQ.peek();
    }
}
