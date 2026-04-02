class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Valid Tree:
            // 1. Every node is connected
            // 2. There are no cycles
        
        if (edges.length > n - 1) return false; // Can have no more edges than this

        // Build an adjacency list
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int k = 0; k < edges.length; k++) {
            if (edges[k][0] < 0 || edges[k][0] >= n) return false;
            if (edges[k][1] < 0 || edges[k][1] >= n) return false;
            adjList.get(edges[k][0]).add(edges[k][1]);
            adjList.get(edges[k][1]).add(edges[k][0]);
        }
        
        // Easy Sol: Do a bfs to check for cycles
        Queue<Integer> bfs = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        bfs.add(0);
        while(!bfs.isEmpty()) {
            int cur = bfs.poll();
            if (visited.contains(cur)) return false;
            visited.add(cur);

            for (int neighbor : adjList.get(cur)) {
                if (!visited.contains(neighbor)) bfs.add(neighbor);
            }
        }

        return visited.size() == n;
        
        // Union find would be great for this
    }
}
