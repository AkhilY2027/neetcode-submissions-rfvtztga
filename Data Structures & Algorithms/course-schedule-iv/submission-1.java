class Solution {
    private void dfs(int i, HashMap<Integer, HashSet<Integer>> prereqs, HashSet<Integer> visited) {
        // Base Case: No prereqs
        if (prereqs.get(i).isEmpty())
            return;
        if (visited.contains(i))
            return;

        // 1. Do DFS into children first – No need to worry about cycles
        for (int prereq : prereqs.get(i))
            dfs(prereq, prereqs, visited);

        // 2. Inherit all prereqs from children
        HashSet<Integer> temp = new HashSet<>();
        for (int prereq : prereqs.get(i))
            temp.addAll(prereqs.get(prereq));
        prereqs.get(i).addAll(temp);

        // 3. Mark as visited
        visited.add(i);
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Could just be a hashmap?
            // If we find one thing is a prereq of another, we have that prereq inherit all of its next class's next classes?
                // But what if next class gains another next class after we do this inheritance?
            // Maybe do this at the end?
                // Would we know the proper order at that point? What if we haven't done this for the next class's inheritance before doing it for the prereq?
        // Perhaps combine with a graph
            // With a dfs, would know which nodes have no prereqs, so can start from there
            // Just add previous nodes to current nodes
        
        // 1. Create an adjacency list
        HashMap<Integer, HashSet<Integer>> prereqs = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            prereqs.put(i, new HashSet<>());
        for (int i = 0; i < prerequisites.length; i++)
            prereqs.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        // 2. Do a dfs within that adjList to get the inherited prereqs
        // HashMap<Integer, HashSet<Integer>> inheritedPrereqs = new HashMap<>();
        // for (int i = 0; i < numCourses; i++)
        //     inheritedPrereqs.put(i, new HashSet<>());
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++)
            dfs(i, prereqs, visited);

        // 3. Check each query based on our inherited prereqs
        List<Boolean> sol = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (prereqs.get(queries[i][0]).contains(queries[i][1])) sol.add(true);
            else sol.add(false);
        }
        return sol;
    }
}