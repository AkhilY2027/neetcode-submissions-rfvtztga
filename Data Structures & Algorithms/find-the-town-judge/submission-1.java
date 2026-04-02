class Solution {
    public int findJudge(int n, int[][] trust) {
        // Can we not just do an adjacency list where we find nodes that don't have any outgoing edges?
            // Meanwhile, we can keep a track of which nodes have how many incoming edges
        // Or simplify:
            // Loop through all trusts and keep track of:
            // Incoming edges for each node
            // If a node has no outgoing edges
        HashMap<Integer, Boolean> outGoingEdges = new HashMap<>();
        HashMap<Integer, Integer> incomingEdges = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            incomingEdges.put(i, 0);
            outGoingEdges.put(i, false);
        }
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            incomingEdges.put(b, incomingEdges.get(b) + 1);
            outGoingEdges.put(a, true);
        }

        // Go through all outgoing edges, see the ones that are false and check if they have all incoming edges
        for (int i = 1; i <= n; i++)
            if (!outGoingEdges.get(i) && incomingEdges.get(i) == n - 1)
                return i;
        return -1;
    }
}