class UnionFind {
    int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int v) {
        if (parent[v] != v)
            parent[v] = find(parent[v]); // Looping until we get the head parent (ex. root node) of our v
                // Also ensures an update for every level of parent[]
        return parent[v];
    }

    public boolean union (int v1, int v2) {
        // In other words, adding an edge between these two – updating both "disjoint" graphs
        int p1 = find(v1), p2 = find(v2);
        if (p1 == p2) return false;
            // In this case, there is already a way to get to p2 from p1 – Adding this direct edge would create a cycle
            // We don't care about anything else for unionfind, so this is the part we want to know the most
        if (rank[p1] > rank[p2]) {
            // Adding p2 to p1's tree
            parent[p2] = p1; // This parent update will trickle down into p2 DAG via the find function later on
            rank[p1] += rank[p2];
        }
        else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // Prim's finds an MST
            // Want critical and pseudo-critical that appears in all/some MSTs

        // Want to use Kruskal's (sort all edges, then add if it doesn't form a cycle)
        
        // 1. Need to sort edges but can't lose original position for solution list, so add as another parameter
        List<int[]> edgeList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++)
            edgeList.add(new int[] {edges[i][0], edges[i][1], edges[i][2], i});
        edgeList.sort(Comparator.comparingInt(a -> a[2]));

        // Add all edges one by one least to greatest (Kruskal's), then see what the mst weight is
        int mstWeight = 0;
        UnionFind findMST = new UnionFind(n);
        for (int[] edge : edgeList)
            if (findMST.union(edge[0], edge[1]))
                mstWeight += edge[2];

        // Now that we know the MST, find other MSTs to get our edges
            // Find critical edges via removing every edge once and seeing if we can make another MST that has the same number
            // Find pseudo-critical edges via starting with that edge then seeing if we can make a true MST starting from that edge
                // This way, critical and pseudo-critical edges don't overlap
        List<Integer> critical = new ArrayList<>();
        List<Integer> psuedoCritical = new ArrayList<>();
        for (int[] edge : edgeList) {
            // Without – For crtical
            UnionFind mstWithout = new UnionFind(n);
            int curWeight = 0;
            for (int[] edge2 : edgeList)
                if (edge2[3] != edge[3] && mstWithout.union(edge2[0], edge2[1]))
                    curWeight += edge2[2];
            // Edge Case for without – by removing, we disconnect the graph entirely (also a critical edge)
            int connected = 0;
            for (int r : mstWithout.rank)
                connected = Math.max(r, connected);
            if (connected != n || curWeight > mstWeight) {
                critical.add(edge[3]);
                continue;
            }

            // With – for pseudo
            UnionFind mstWith = new UnionFind(n);
            mstWith.union(edge[0], edge[1]);
            curWeight = edge[2];
            for (int[] edge2 : edgeList)
                if (mstWith.union(edge2[0], edge2[1]))
                    curWeight += edge2[2];
            if (curWeight == mstWeight)
                psuedoCritical.add(edge[3]);
        }

        List<List<Integer>> sol = new ArrayList<>();
        sol.add(critical);
        sol.add(psuedoCritical);
        return sol;
    }
}