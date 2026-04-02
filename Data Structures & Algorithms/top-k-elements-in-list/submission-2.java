class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numToCount = new HashMap<>();

        // Get all counts from nums
        for (int i = 0; i < nums.length; i++)
            numToCount.put(nums[i], numToCount.getOrDefault(nums[i], 0) + 1);

        // Loop through with priority queue and find k greatest
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1] // Reverse to get max out instead of min out
        );
        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet())
            pq.add(new int[] {entry.getKey(), entry.getValue()});
        
        // Get those we need
        int[] sol = new int[k];
        for (int i = 0; i < k; i++) {
            sol[i] = pq.poll()[0];
        }
        return sol;
    }
}
