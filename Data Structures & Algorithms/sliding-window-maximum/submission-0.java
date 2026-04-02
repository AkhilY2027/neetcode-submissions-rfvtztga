class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] sol = new int[nums.length - k + 1];

        // Use a heap to continuously keep a track of the greatest element at any given time
        // int l = 0, r = k - 1;
        // PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        // for (int i = l; i < r; i++) {
        //     q.push(nums[i]);
        // }
        // sol[0] = q.peek();
        // // Algo: Move the l and r -> Only do work if cur maximum value is outside the heap

        // for (int i = 1; i < sol.length; i++) {
        //     // On each new element, pop any elements less than it (since they don't matter anyway)
        //     while(q.peek() < nums[r + i])
        //         q.pop();
        //     q.push(nums[r + i]);
        // }

        // Use a deque data structure as we can affect both the front and the last at the same time
        Deque<Integer> q = new LinkedList<>(); // Only put indeces in here so positions can be easily tracked
        int l = 0, r = 0;
        while(r < nums.length) {
            // First case: Add the new number to the deque
                // Remove any values in the deque that are lesser than this new number (unnecessary)
            while (!q.isEmpty() && nums[q.getLast()] < nums[r])
                q.removeLast();
            q.addLast(r);

            // Second, ensure that the sliding window is not out of bounds
            if (l > q.getFirst())
                q.removeFirst();
            
            // Update output (ONLY IF THERE ARE K ELEMENTS)
            if ((r + 1) >= k) {
                sol[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return sol;
    }
}
