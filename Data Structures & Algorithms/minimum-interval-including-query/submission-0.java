class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort intervals and query and then search linearly
            // To get min interval at every point, use priorityqueue/minHeap

        Arrays.sort(intervals, Comparator.comparingInt(
            a -> a[0]
        ));
        // Cannot directly sort queries as we need to maintain the order for solution
            // Instead, have it be a copy of array that is sorted + Use HashMap to know which is best for which query
        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);
        HashMap<Integer, Integer> queryToAnswer = new HashMap<>();
        // Finally, PriorityQueue
        PriorityQueue<int[]> minInterval = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Loop through
        int intervalIndex = 0;
        for (int i = 0; i < sortedQueries.length; i++) {
            // Push in all intervals that have a left value <= query
            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= sortedQueries[i]) {
                int[] toAdd = {(intervals[intervalIndex][1] - intervals[intervalIndex][0] + 1), intervals[intervalIndex][1]}; // Storing length and right value
                // System.out.println(Arrays.toString(toAdd));
                minInterval.add(toAdd);
                intervalIndex++;
            }

            // Pop out all intervals that have a right value < query
            while (!minInterval.isEmpty() && minInterval.peek()[1] < sortedQueries[i]) {
                minInterval.poll();
            }

            // Final one on minheap is answer/-1
            queryToAnswer.put(sortedQueries[i], minInterval.isEmpty() ? -1 : minInterval.peek()[0]);
        }

        // Match map to actual solution
        int[] sol = new int[queries.length];
        for (int i = 0; i < sol.length; i++) {
            sol[i] = queryToAnswer.get(queries[i]);
        }
        return sol;
    }
}
