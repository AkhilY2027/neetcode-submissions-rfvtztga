class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Goal: Find the shortest interval i where query[i] is in between intervals[i]

        // Brute Force: Can search intervals for each query – O(n*m)

        // However, can notice an intuition: If we can search through intervals + queries least to greatest,
            // We can avoid repeated work and not use intervals we know aren't going to be chosen
            // O(nlogn + mlogm)
            // However, our ultimate goal is to find the least size interval, so across the intervals a query can be in, use a heap to keep track of what the solution actually is
            // Also, because our queries are sorted, order is lost
                // Use a hashmap to correspond query to answer, then create sol array at end
        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);

        HashMap<Integer, Integer> best = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        int intervalPointer = 0;
        for (int i = 0; i < sortedQueries.length; i++) {
            // Add all intervals that this query can belong to
            while(intervalPointer < intervals.length &&
            intervals[intervalPointer][0] <= sortedQueries[i]) {
                pq.add(
                    new int[] {
                        (intervals[intervalPointer][1] - intervals[intervalPointer][0] + 1), // Size
                        intervals[intervalPointer][1] // Right pointer for tie breakers
                    }
                );
                intervalPointer++;
            }

            // Remove all intervals that this query has exceeded
            while (!pq.isEmpty() && pq.peek()[1] < sortedQueries[i])
                pq.poll();
            
            // Then, place the topmost element into the hashmap
            best.put(sortedQueries[i], 
                pq.isEmpty() ? -1 : pq.peek()[0]
            );
        }

        int[] sol = new int[queries.length];
        for (int i = 0; i < sol.length; i++) {
            sol[i] = best.get(queries[i]);
        }
        return sol;
    }
}
