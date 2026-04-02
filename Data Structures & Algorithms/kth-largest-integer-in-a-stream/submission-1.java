class KthLargest {

    PriorityQueue<Integer> queue;
    int limit;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<Integer>(k);
        limit = k;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k)
                queue.poll();
        }
    }
    
    public int add(int val) {
        queue.add(val);
        if (queue.size() > limit)
            queue.poll();
        return queue.peek();
    }
}
