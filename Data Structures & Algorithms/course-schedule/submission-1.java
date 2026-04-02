class Solution {
    private boolean dfs(int i, HashMap<Integer, HashSet<Integer>> preGraph, HashSet<Integer> visited, HashSet<Integer> inCycle) {
        if (visited.contains(i)) return true; // Already visited after checking the cycle – Go
        if (inCycle.contains(i)) return false;
        inCycle.add(i);

        for (int neighbor : preGraph.get(i))
            if (!dfs(neighbor, preGraph, visited, inCycle))
                return false;

        // inCycle.remove(i);
        visited.add(i);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Basically, we just don't want to be caught in a cycle
        // Easy solution: Build a graph of prereqs and find if there's a cycle
        // Harder solution: Union Find

        HashMap<Integer, HashSet<Integer>> preGraph = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            preGraph.put(i, new HashSet<>());
        for (int i = 0; i < prerequisites.length; i++)
            preGraph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        // Cycle Detection
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++)
            if (!dfs(i, preGraph, visited, new HashSet<>()))
                return false;
        return true;
    }
}
