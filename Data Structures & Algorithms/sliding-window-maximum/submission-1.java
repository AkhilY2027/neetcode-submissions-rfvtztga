class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Intuition:
            // Any numbers to the left of the maximum element in a sliding window are useless to remember
            // Already know that maximum of next sliding window will be either current max or new element, so use that to advantageint[] sol = new int[nums.length - k + 1];

        int[] sol = new int[nums.length - k + 1];

        // Use a dequeue to add to both beginning and end of a linkedlist at the same time
            // To fit our intuition, make deque a decreasing list so only potential maximums are considered
            // Thus, max for every sliding window is the leftmost element of this deque
        Deque<Integer> dq = new LinkedList<>();
        int l = 0, r = 0;
        while (r < nums.length) { // Add index r
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[r]) // Ensure we don't need any unnecessary elements (lesser than known max)
                dq.removeLast();
            dq.addLast(r);

            // Ensure that our deque only contains indices within our l and r
            if (l > dq.getFirst())
                dq.removeFirst();
            
            // Finally, add to output since we know current l and r represent a sliding window within nums
            if ((r + 1) >= k) { // Do this to ensure our sliding window has at least reached a length of k
                sol[l] = nums[dq.getFirst()];
                l++;
            }
            r++;
        }
        return sol;
    }
}
