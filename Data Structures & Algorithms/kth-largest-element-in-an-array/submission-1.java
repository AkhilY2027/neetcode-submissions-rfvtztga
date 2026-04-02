class Solution {
    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    public int quickSelect(int[] nums, int l, int r, int target) {
        int pivot = nums[r], pointer = l;

        // Iterate
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                // Must swap pointer and i
                swap(nums, i, pointer);
                pointer++;
            }
        }
        swap(nums, pointer, r);

        // Now, check
        if (pointer > target) return quickSelect(nums, l, pointer - 1, target);
        else if (pointer < target) return quickSelect(nums, pointer + 1, r, target);
        else return nums[pointer];
    }
    public int findKthLargest(int[] nums, int k) {
        // First, sorting:
        // Arrays.sort(nums);
        // return nums[nums.length - k];

        // Second, min Heap:
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // for (int num: nums) {
        //     minHeap.offer(num);
        //     if (minHeap.size() > k) { // Only keep the kth greatest numbers
        //         minHeap.poll();
        //     }
        // }
        // return minHeap.poll();

        // Third, Quick Select - mutation of quick sort (which Arrays.sort() already uses)
            // Worst case is O(n^2) but average is O(n)
            // Algo: Select a random pivot and partition the array such that:
                // All elements less than pivot are below it
                // All elements greater than pivot are above it
            // After: Find Look at the numbers above nums.length - k as we know that that is where our target number will reside
                // Couple of other tricks as mentioned in the video to optimize it
                // O(n) because we only need to look at one half of the partition, not both halves like in quick sort
        int target = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, target);
    }
}
