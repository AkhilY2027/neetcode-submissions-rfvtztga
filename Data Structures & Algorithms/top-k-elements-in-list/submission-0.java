class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToApperance = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToApperance.put(nums[i], numToApperance.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[0] - a[0]
        );
        for (Map.Entry<Integer, Integer> entry : numToApperance.entrySet()) {
            pq.add(new int[] {entry.getValue(), entry.getKey()});
        }

        int[] sol = new int[k];
        for (int i = 0; i < k; i++) {
            sol[i] = pq.poll()[1];
        }
        return sol;
    }
}
