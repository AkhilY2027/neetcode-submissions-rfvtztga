class Solution {
    private boolean dfs(int curNode, int prevNode, Set<Integer> visited, List<List<Integer>> adjList) {
        if (visited.contains(curNode))
            return false;
        
        visited.add(curNode);
        for (int neighbor : adjList.get(curNode)) {
            if (neighbor == prevNode)
                continue;
            if (!dfs(neighbor, curNode, visited, adjList))
                return false;
        }
        return true;
    }
    
    public boolean validTree(int n, int[][] edges) {
        // Two conditions for being a valid tree:
            // 1. No Cycles
            // 2. All nodes are connected
        
        // Idea: Just do a dfs based on adjacency list created from edges
        if (edges.length > n - 1)
            return false;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // Do dfs – Only a cycle when we go along path that isn't direct back to prev node
        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, visited, adjList))
            return false;
        return visited.size() == n;
    }
}
