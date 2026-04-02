class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Is this not just MST?

        // 1. Create the adjacency list
        HashMap<Integer, ArrayList<Pair<Integer, Integer>>> adjList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjList.putIfAbsent(i, new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adjList.get(times[i][0]).add(new Pair<>(times[i][1], times[i][2]));
        }

        // // 2. Prim's
        // HashSet<Integer> visited = new HashSet<>();
        // visited.add(k);
        // PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
        //     // Comparator needed
        //     (a,b) -> a.getValue() - b.getValue()
        // );
        // pq.addAll(adjList.get(k));
        // int minTime = 0;
        // while (visited.size() != n && !pq.isEmpty()) {
        //     // Continuously dequeue until pq gives an edge that goes to a vertex not here
        //     if (pq.isEmpty()) return -1;
        //     Pair<Integer, Integer> curPair = pq.poll();
        //     while (visited.contains(curPair.getKey())) {
        //         if (pq.isEmpty()) return -1;
        //         curPair = pq.poll();
        //     }

        //     // Add this edge
        //     minTime += curPair.getValue();
        //     visited.add(curPair.getKey());
        //     pq.addAll(adjList.get(curPair.getKey()));
        // }

        // return visited.size() != n ? -1 : minTime;

        // 3. Djikstra's - Literally just the largest number
        HashSet<Integer> visited = new HashSet<>();
        // Initialize a PQ
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            // Comparator needed
            (a,b) -> a.getValue() - b.getValue()
        );
        pq.add(new Pair<>(k, 0));
        // Initialize a distances array
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        int minDis = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> curPair = pq.poll();
            int curPoint = curPair.getKey();
            if (visited.contains(curPoint)) continue;

            int curDis = curPair.getValue();
            distances[curPoint] = curDis;
            minDis = Math.max(minDis, curDis);
            visited.add(curPoint);

            for (Pair<Integer, Integer> p : adjList.get(curPoint)) {
                int nextPoint = p.getKey(), nextDis = p.getValue();
                if (!visited.contains(nextPoint)) {
                    pq.add(new Pair<>(nextPoint, nextDis + curDis));
                }
            }
        }

        return visited.size() == n ? minDis : -1;
    }
}
