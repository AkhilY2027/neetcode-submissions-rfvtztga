class Solution {
    public boolean dfs(HashSet<Integer> visited, HashSet<Integer> cycleNodes, ArrayList<Integer> output, HashMap<Integer, HashSet<Integer>> adjList, int i) {
        if (visited.contains(i)) return true;
        if (cycleNodes.contains(i)) return false;
        cycleNodes.add(i);

        // First, dfs on any i available
        for (int neighbor : adjList.get(i)) {
            if (!dfs(visited, cycleNodes, output, adjList, neighbor))
                return false;
        }
        cycleNodes.remove(i);

        // Then, check if we can add to visited and final output
        visited.add(i);
        output.add(i);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Must do a topological sort

        // 1. Create an adjacency list
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // 2. Do a dfs at every node
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(visited, new HashSet<>(), output, adjList, i))
                return new int[0];
        }

        // return output.toArray(new int[0]);
        int[] sol = new int[output.size()];
        for (int i = 0; i < sol.length; i++) {
            sol[i] = output.get(i);
        }
        return sol;
    }
}
