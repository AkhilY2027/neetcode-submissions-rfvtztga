class Solution {
    public boolean dfs(List<String> sol, String cur, HashMap<String, List<String>> adjList, int stopSize) {
        if (sol.size() == stopSize) return true; // Got to a flight path that gives us the nodes we need
            // Need our flight path to be numTickets + 1

        if (!adjList.containsKey(cur)) return false; // Possibility there is no tickets going out corresponding to this location
            // If so, this location should be the end of our flight path, not in middle – Bad path

        // In this dfs, when we go to a destination, we want to remove that edge/ticket from adjList
            // This is because we can possibly visit a node multiple times but we can't visit an edge more than once
            // So need to keep a copy of our current adj edges in case we found a bad edge and need to backtrack
        List<String> copy = new ArrayList<>(adjList.get(cur));
        for (int i = 0; i < copy.size(); i++) {
            String des = copy.get(i);
            adjList.get(cur).remove(i);
            sol.add(des);

            if (dfs(sol, des, adjList, stopSize)) return true;

            // Bad path – Use another neighbor
            adjList.get(cur).add(i, des);
            sol.remove(sol.size() - 1);
        }
        return false;
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        // Best way is to create a "graph" and then do a dfs

        // 1. Ensure tickets is sorted lexigraphically
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));

        // 2. Make an adjacency list based on the tickets
        HashMap<String, List<String>> adjList = new HashMap<>();
        for (List<String> ticket : tickets) {
            adjList.putIfAbsent(ticket.get(0), new ArrayList<>()); // Use arraylist to preserve order
            adjList.get(ticket.get(0)).add(ticket.get(1));
        }

        // 3. Do a dfs starting from JFK
        List<String> sol = new ArrayList<>();
        sol.add("JFK");
        if (dfs(sol, "JFK", adjList, tickets.size() + 1)) return sol;
        return new ArrayList<>();
    }
}
