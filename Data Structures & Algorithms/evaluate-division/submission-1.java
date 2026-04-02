class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Based on equations and value solutions, find values of variables to solve queries
            // Cannot evaluate a query when: Using variable that isn't there
        
        // Initial idea: Go through equations somehow to get values of each variable
            // However, not likely with some formulas
            // Instead, need to transform existing equations to create queries
        
        // Instead, think of a graph:
            // When you have an a/b, can multiply by another level b/c to transform into a/c
            // Thus, we're trying to transform equations until we can reach the final answer
                // However, this is hard to code
            // Instead, think of each equation as values on edge between two nodes
                // So a -> b = 2, b -> c = 3
                // Then, traversing through that to find end c from start a will return 6 (a/c)
                // And when going in reverse order, need to take the inverse of each value!
        
        // 1. Create the graph per each node
        HashMap<String, HashMap<String, Double>> adjList = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            adjList.putIfAbsent(a, new HashMap<>());
            adjList.putIfAbsent(b, new HashMap<>());
            adjList.get(a).put(b, values[i]);
            adjList.get(b).put(a, 1 / values[i]);
        }

        // 2. Traverse the graph to find the queries
            // Ensure that we don't have any cycle detection
        double[] sol = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String des = queries.get(i).get(1);
            sol[i] = bfs(src, des, adjList);
        }
        return sol;
    }

    private double bfs(String src, String des, HashMap<String, HashMap<String, Double>> adjList) {
        if (!adjList.containsKey(src) || !adjList.containsKey(des))
            return -1;
        
        Queue<Pair<String, Double>> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(new Pair<>(src, 1.0));
        visited.add(src);

        while (!q.isEmpty()) {
            Pair<String, Double> cur = q.poll();
            String curNode = cur.getKey();
            Double curVal = cur.getValue();

            if (curNode.equals(des))
                return curVal;
            
            // Add neighbors
            for (String neighbor : adjList.get(curNode).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(new Pair<>(neighbor, curVal * adjList.get(curNode).get(neighbor)));
                }
            }
        }
        return -1;
    }
}