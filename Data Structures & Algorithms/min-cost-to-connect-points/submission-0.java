class Solution {
    public int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    public int minCostConnectPoints(int[][] points) {
        // Minimum Spanning Tree - Prim's Algorithm

        // First, make an adjacency list of all possible edges for each point
        HashMap<Integer, HashMap<Integer, Integer>> adjList = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            adjList.put(i, new HashMap<>()); // Format is node, cost
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int d = dist(points[i][0], points[i][1], points[j][0], points[j][1]);
                adjList.get(i).put(j, d);
                adjList.get(j).put(i, d);
            }
        }

        // Then, use PQ and Visited set to count all minimum edges
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> PQ = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[1])
        );
        PQ.add(new int[] {0, 0});
        int totalCost = 0;
        while (visited.size() < points.length) {
            // Continue popping until we find something
            int[] point = PQ.poll();
            int cost = point[1], node = point[0];
            if (visited.contains(node)) continue;
            totalCost += cost;
            visited.add(node);
            // Add all neighbors and their costs
            for (Map.Entry<Integer, Integer> e : adjList.get(node).entrySet()) {
                int nCost = e.getValue();
                int nNode = e.getKey();
                // Don't want to unnecessarily add points we already visited
                if (!visited.contains(nNode)) PQ.add(new int[] {nNode, nCost});
            }
        }
        return totalCost;
    }
}
