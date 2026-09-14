class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Brute Force: DFS on every n to figure out minimum heights

        // Intuition: Instead of thinking of it like a tree, think of it as nodes with neighbors
            // Leaves are always the "outermost" nodes with the least amount of edges
                // Otherwise, if you have >1 edges, then you are a node in the middle of the tree
                // We know that a leaf node can never be the root node because it is farthest away from every other node
            // Thus, "eliminate" all the leaf nodes to "trim" the tree
                // And then repeat the process until we get to at most 2 roots (otherwise, will still have a difference in heights from edges)
        
        // Intuition 2: In a random longest path, the middle node of the path becomes the root that flattens the tree
            // Thus, with any random dfs, if we find a random longest path, then we can find the root node to correlate

        // Easier to code Intuition 1:
        if (n == 1) {
            List<Integer> sol = new ArrayList<>();
            sol.add(0);
            return sol;
        }

        // 1. Create adjacency list
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++)
            adjList.put(i, new HashSet<>());
        
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // 2. Find leaves for first layer
        int[] edgeCount = new int[n];
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            edgeCount[i] = adjList.get(i).size();
            if (edgeCount[i] == 1)
                leaves.add(i);
        }

        // 3. Continuously cull leaves
            // Essentially, go through each leaf and remove from the adjcency list edges – easier to do with a queue
        while (!leaves.isEmpty()) {
            if (n <= 2) return new ArrayList<>(leaves);
            int size = leaves.size();
            for (int i = 0; i < size; i++) {
                int curNode = leaves.poll();
                n--; // Remove
                for (int neighbor : adjList.get(curNode))
                    if (--edgeCount[neighbor] == 1)
                        leaves.add(neighbor);
            }
        }

        return new ArrayList<>();
    }
}