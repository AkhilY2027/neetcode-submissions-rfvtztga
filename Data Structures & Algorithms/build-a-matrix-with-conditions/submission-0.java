class Solution {
    private boolean dfs(int i, HashSet<Integer> curPath, HashSet<Integer> visited, ArrayList<Integer> order, Map<Integer, HashSet<Integer>> adjList) {
        // Base case: If repeated node on path, then false – But if its an actual node we visited before, then we just return to the previous
        if (curPath.contains(i)) return false;
        if (visited.contains(i)) return true;

        // Go through neighbors and add original node back once we're done with neighbors
        visited.add(i);
        curPath.add(i);
        for (int n : adjList.get(i))
            if (!dfs(n, curPath, visited, order, adjList))
                return false;
        curPath.remove(i);
        order.add(i);
        return true;
    }

    private int[] topologicalSort(int k, int[][] edges) {
        // 1. Create an adjacency list
        Map<Integer, HashSet<Integer>> adjList = new HashMap<>();
        for (int i = 1; i <= k; i++)
            adjList.put(i, new HashSet<>());
        for (int[] edge : edges)
            adjList.get(edge[0]).add(edge[1]); // Prereq -> Actual

        // 2. DFS and store in reverse
        HashSet<Integer> visited = new HashSet<>();
        // HashSet<Integer> curPath = new HashSet<>();
        ArrayList<Integer> order = new ArrayList<>();
        for (int i = 1; i <= k; i++)
            if (!visited.contains(i))
                if (!dfs(i, new HashSet<>(), visited, order, adjList))
                    return null;
        
        // 3. Reverse the order (because we did actual to prereqs because of our dfs traversal – need prereqs before actual)
        Collections.reverse(order);
        return order.stream().mapToInt(i -> i).toArray();
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Row conditions: Prereqs for rows specifically
            // Same thing for cols
            // Observation 1: Every single element in the matrix has its own row and column
        
        // Preliminary Algo: Run prereqs algo on both rows and cols and find out each's positions that way?
            // Using topological sort: Essentially reverse DFS
                // If there is a cycle within the prereqs of either rows/cols, then either graph is invalid

        // 1. Find row + col order using topological sort
        int[] rowOrder = topologicalSort(k, rowConditions);
        if (rowOrder == null) return new int[0][0];
        int[] colOrder = topologicalSort(k, colConditions);
        if (colOrder == null) return new int[0][0];

        // 2. Correspond each number to which row and col they are supposed to be in
        Map<Integer, Integer> kToRow = new HashMap<>();
        for (int i = 0; i < rowOrder.length; i++)
            kToRow.put(rowOrder[i], i);
        Map<Integer, Integer> kToCol = new HashMap<>();
        for (int i = 0; i < colOrder.length; i++)
            kToCol.put(colOrder[i], i);

        // 3. Construct the final graph
        int[][] sol = new int[k][k];
        for (int i = 1; i <= k; i++)
            sol[kToRow.get(i)][kToCol.get(i)] = i;
        return sol;
    }
}