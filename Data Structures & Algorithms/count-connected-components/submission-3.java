class Solution {
    public int countComponents(int n, int[][] edges) {
        HashSet<Integer> unvisited = new HashSet<>();
        // boolean[] visited = new visited[n];
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            unvisited.add(i);
            adjList.put(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        // Just run BFS constantly until unvisited is empty
        int iterations = 0;
        while (!unvisited.isEmpty()) {
        // for (int i = 0; i < n; i++) {
        //     if (visited[i])
        //         continue;
            
            iterations++;
            int curNode = -1;
            for (int i : unvisited) {
                curNode = i;
                // unvisited.remove(i);
                break;
            }

            // System.out.println(unvisited);

            // Now, run bfs
            Queue<Integer> q = new LinkedList<>();
            q.add(curNode);
            while (!q.isEmpty()) {
                int curQ = q.poll();
                if (!unvisited.contains(curQ)) continue;
                unvisited.remove(curQ);

                for (int neighbor : adjList.get(curQ)) {
                    if (unvisited.contains(neighbor)) q.add(neighbor);
                }
            }
        }
        return iterations;
    }
}
