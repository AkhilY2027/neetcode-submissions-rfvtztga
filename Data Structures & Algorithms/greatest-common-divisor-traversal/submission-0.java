class UnionFind {
    private int[] parent;
    private int[] size;
    private int n;

    public UnionFind(int n) {
        this.n = n;
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;
        size = new int[n + 1];
        Arrays.fill(size, 1);
    }

    public int find(int node) {
        if (parent[node] != node)
            parent[node] = find(parent[node]);
        return parent[node];
    }

    public boolean union(int u, int v) {
        int parent_u = find(u);
        int parent_v = find(v);
        if (parent_u == parent_v)
            return false;
        if (size[parent_u] > size[parent_v]) {
            size[parent_u] += size[parent_v];
            parent[parent_v] = parent_u;
        }
        else {
            size[parent_v] += size[parent_u];
            parent[parent_u] = parent_v;
        }
        n--;
        return true;
    }

    public boolean isConnected() {
        return n == 1;
    }
}

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        // Basically, if there are divising factors between two numbers, then can traverse there
            // Want to know if there is a way to "traverse" between every single number pair

        // Intuition: Because we're looking for connections between numbers, can equate this to a graph traversal (See if it is all one connected component)
            // In fact, since if we find a connection between one pair, we can propogate that connection out to more – actually more of a Union-Find problem
                // Must use indices of numbers instead of numbers themselves because there is possibility of duplicates
            // However, graph traversal will still not make this fast enough
                // At end, will have to check over all factors and see if they are connected
                // Instead, use Prime Factorization for GCD
                    // Each prime factor we find within a number will have its own union find correlated to it
                        // Even better, just store the first element we find of that prime factor because we can "merge" per prime factor
                // Essentially, when we reduce a number to its prime factorizations, we find the other numbers we can traverse to because they share prime factors
                    // Then, it's all a matter of seeing if we can traverse through them all

        // Algo:
            // For every number, get the prime factorization of that number
                // If this specific prime number has not yet been found, record as the first instance within a hashmap
                // Otherwise, if it has, we know there is a "jump" between our current number and the previous holder of the prime factorization
                    // Thus, union find between the both of them (we know the location of the other one through the hashmap)
            // Finally, see if all prime factorizations go into one connected graph
                // Since union find records "jumps", there needs to n total jumps for it to be connected – otherwise, we are disconnected in some way
            // Time Complexity: (m + nsqrt(m)), Space Complexity: O(nlogm)

        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> factorMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int curNum = nums[i];

            // Find all prime factors within this num – place into the union find
                // Union find will connected indices together (basically linking possible jumps)
            int curFactor = 2;
            while (curFactor * curFactor <= curNum) {
                if (curNum % curFactor == 0) {
                    // Found a prime factor – Add to union find only if we have found this factor before
                        // Remember, we are using the union find to link together "jumps" between numbers, so shared prime factors must be recorded
                    if (factorMap.containsKey(curFactor))
                        uf.union(i, factorMap.get(curFactor));
                    else
                        factorMap.put(curFactor, i);

                    // To ensure we don't use the same prime factor again
                    while (curNum % curFactor == 0)
                        curNum /= curFactor;
                }
                curFactor++;
            }

            // Do this one last time in case our division wasn't enough
            if (curNum > 1)
                if (factorMap.containsKey(curNum))
                    uf.union(i, factorMap.get(curNum));
                else
                    factorMap.put(curNum, i);
        }

        return uf.isConnected();
    }
}