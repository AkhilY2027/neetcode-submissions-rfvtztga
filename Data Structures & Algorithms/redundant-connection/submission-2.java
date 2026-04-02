class Solution {
    public int find(int[] par, int v) {
        int p = par[v];
        while (p != par[p]) {
            // Finding root node
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    public boolean union(int[] par, int[] rank, int v1, int v2) {
        int p1 = find(par, v1);
        int p2 = find(par, v2);

        if (p1 == p2) return false;
        else if (rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        // Algo: Use a hashset
            // Can add vertices of edges
            // If we find an edge whose vertices (both) are within the set, return that edge
        // HashSet<Integer> set = new HashSet<>();
        // set.add(edges[0][0]);
        // set.add(edges[0][1]);
        // for (int i = 1; i < edges.length; i++) {
        //     int v1 = edges[i][0];
        //     int v2 = edges[i][1];
        //     if (set.contains(v1) && set.contains(v2))
        //         return edges[i];
        //     set.add(v1);
        //     set.add(v2);
        // }
        // return new int[2];

        // Basically do DFS - If we find the same vertex, return that edge

        // Or can do Union Find
        int[] par = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = i;
        }

        for (int[] edge : edges) {
            if(!union(par, rank, edge[0], edge[1]))
                return edge;
        }
        return new int[2];
    }
}
