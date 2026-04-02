class Solution {
    public boolean dfs(HashMap<String, List<String>> adjList, String curLocation, List<String> sol, int target) {
        if (sol.size() == target) return true; // Done and complete
        if (!adjList.containsKey(curLocation)) return false; // Unable to complete

        List<String> possibleLocations = new ArrayList<>(adjList.get(curLocation));
        for (int i = 0; i < possibleLocations.size(); i++) {
            String toGo = possibleLocations.get(i);
            adjList.get(curLocation).remove(i); // Remove this neighbor since we are going to it
            sol.add(toGo);

            if (dfs(adjList, toGo, sol, target)) return true; // Eventually found the answer

            // This neighbor sent us down bad path, so backtrack
            adjList.get(curLocation).add(i, toGo);
            sol.remove(sol.size() - 1);
        }
        return false;
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        // 1. Sort the tickets lexographically so we add into the adjList lexographically
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));

        // 2. Create an adjList based on these tickets (graph)
        HashMap<String, List<String>> adjList = new HashMap<>();
        for (List<String> ticket : tickets) {
            adjList.putIfAbsent(ticket.get(0), new ArrayList<>());
            adjList.get(ticket.get(0)).add(ticket.get(1));
        }

        // 3. Just traverse the graph starting from JFK
            // Will always have JFK + Go in order of the adjList above
            // Done when final result is tickets.length + 1 (Since we start at JFK automatically + All destinations)
            // Potential that we greedily add a bad edge, so backtrack when necessary
        List<String> sol = new ArrayList<String>();
        sol.add("JFK");
        if (dfs(adjList, "JFK", sol, tickets.size() + 1)) return sol;
        return new ArrayList<>(); // Impossible to create
    }
}
