class Solution {
    public boolean dfs(int i, HashMap<Integer, HashSet<Integer>> nodeMap, HashSet<Integer> visited, HashSet<Integer> inCycle, ArrayList<Integer> sol) {
        // visited is for nodes that we have added to sol, inCycle is to keep track of current path so we don't end up in a cycle
        if (visited.contains(i)) return true;
        if (inCycle.contains(i)) return false; // Found a cycle, should not continue as current schedule has no way of being resolved
        inCycle.add(i);

        // Add prereqs first by dfss on them
        for (int neighbor : nodeMap.get(i))
            if (!dfs(neighbor, nodeMap, visited, inCycle, sol))
                return false;
        inCycle.remove(i);

        // Thus, since no conflicts and we're back at this level dealing with all prereqs, add this class to the final solution
        visited.add(i);
        sol.add(i);
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Can you not just create a graph from the prereqs and then do a dfs on all of them?

        // 1. Create a graph by creating nodes for every course
        HashMap<Integer, HashSet<Integer>> nodeMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            nodeMap.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            nodeMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // 2. Run a dfs through every node and see where we end up
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> sol = new ArrayList<>(); // Convert into int[] later
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, nodeMap, visited, new HashSet<>(), sol)) return new int[0];
        }
        
        // 3. Convert ArrayList into final array
        int[] solArr = new int[sol.size()];
        for (int i = 0; i < solArr.length; i++)
            solArr[i] = sol.get(i);
        return solArr;
    }
}
