class Solution {
    public int distCal(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    
    public int minCostConnectPoints(int[][] points) {
        // Find distances between all points and then do a bfs to find least cost of connection?
            // Or use Djikstra's

        // Actually creating an MST using Prim's

        // 1. Create Adj List
        HashMap<Integer, HashMap<Integer, Integer>> adjList = new HashMap<>(); // Index -> Neighbor, cost
        for (int i = 0; i < points.length; i++)
            adjList.put(i, new HashMap<>());
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dis = distCal(points[i][0], points[i][1], points[j][0], points[j][1]);
                adjList.get(i).put(j, dis);
                adjList.get(j).put(i, dis);
            }
        }

        // 2. Prim's using PQ and Visited set
            // Start with one vertex, add least cost neighbor, then add neighbor's neighbors to PQ and so on
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1] // Uses neighbor, distance
        );
        pq.add(new int[] {0, 0});
        int totalCost = 0;
        while (visited.size() < points.length) {
            // Steps:
                // 1. Add least cost neighbor (from pq) to visited
                // 2. Add all of those neighbors (not visited) to pq
                // 3. Repeat
            int[] curNode = pq.poll();
            if (visited.contains(curNode[0])) continue; // Really shouldn't happen
            visited.add(curNode[0]);
            totalCost += curNode[1];

            for (Map.Entry<Integer, Integer> e : adjList.get(curNode[0]).entrySet()) {
                if (!visited.contains(e.getKey())) {
                    pq.add(new int[] {e.getKey(), e.getValue()});
                }
            }
        }
        return totalCost;
    }
}
