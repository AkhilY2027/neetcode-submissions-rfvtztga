class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Can do a linear search via priority queue and order by absolute value
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Math.abs(x - arr[a]) - Math.abs(x - arr[b]) == 0 ? arr[a] - arr[b] : Math.abs(x - arr[a]) - Math.abs(x - arr[b])
        );

        // Add into pq
        for (int i = 0; i < arr.length; i++)
            pq.add(i);

        // Then, get k closest elements
        List<Integer> sol = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            sol.add(arr[pq.poll()]);
        }
        Collections.sort(sol);
        return sol;
    }
}