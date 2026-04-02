class Solution {
    public boolean dfs(HashMap<Integer, HashSet<Integer>> preReq, HashSet<Integer> visitingInCycle, HashSet<Integer> alreadyVisited, int cur) {
        if (visitingInCycle.contains(cur)) return false; // Cycle
        if (alreadyVisited.contains(cur)) return true; // Already checked – No cycles from here

        visitingInCycle.add(cur);
        for (int pre : preReq.get(cur)) {
            if (!dfs(preReq, visitingInCycle, alreadyVisited, pre)) return false;
        }
        visitingInCycle.remove(cur);
        alreadyVisited.add(cur);
        return true;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Essentially, can only stop if there's a cycle
        // Thus, either DFS Cycle Detection + Topological Sort

        // Create an adjcency List (use HashMap to get retrival easier)
        HashMap<Integer, HashSet<Integer>> preReq = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preReq.putIfAbsent(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            preReq.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // Then, do cycle detection with DFS on every node
            // Have two visited arrays – one for total and one for each dfs
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(preReq, new HashSet<>(), visited, i)) return false;
        }
        return true;
    }
}
