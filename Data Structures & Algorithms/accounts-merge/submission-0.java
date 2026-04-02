// Standard UF class structure
class UnionFind {
    private int[] parent; // Represents parent node for each node
    private int[] rank; // Represents how many nodes are in the disjoint set this node belongs to

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) { // At beginning, all are disjoint
            parent[i] = i;
            rank[i] = i;
        }
    }

    // Finding the parent for the specific node in UF
        // We're also updating parent as we go along
    public int find(int i) {
        if (i != parent[i])
            parent[i] = find(parent[i]);
        return parent[i];
    }

    // Unioning two disjoing sets via these two indices
    public boolean union(int i1, int i2) {
        int p1 = find(i1);
        int p2 = find(i2);
        if (p1 == p2)
            return false; // Already unioned
        
        // Smaller set gets devoured by bigger set
            // Since we have the merge here, parents will update on find function
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Want to merge people that share a common email within their accounts
            // People with the same name don't have to be merged – Could be two separate people
        
        // Ideas:
            // HashSet to identify all emails at once
            // Then, a specific "merge" algorithm to merge the two accounts together
        
        // Intuition: Notice that if we're linearly going through accounts, we merge two elements together, then that with another element, and so on
            // This intuition shows that this is a graph problem
        
        // Easy Solution: Do a dfs between accounts

        // Even better solution is to do a dfs between emails/union find solution, but that is harder to code
            // How this would work: Create an association between emails and their accountIndexes (not names)
            // Then, as we're going through the accounts, check if any account has an email associated with multiple accounts – merge with all accounts then and there
            // Can do via a Union Find data structure
                // Find the "leader" for each connected disjoint set to get the name for that person + index it should be on
                // Creates a single account to aggregate all accounts into one

        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emailToAccount = new HashMap<>(); // Email -> Account Index

        // Initialize UF
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAccount.containsKey(email))
                    uf.union(i, emailToAccount.get(email)); // Union with the other account
                else
                    emailToAccount.put(email, i);
            }
        }

        // Group emails by their parent accounts
            // Already unioned so we have to find the parent for each merged disjoint set
        Map<Integer, List<String>> mergedGroups = new HashMap<>();
        for (Map.Entry<String, Integer> e : emailToAccount.entrySet()) {
            String email = e.getKey();
            int accountIndex = e.getValue();
            int p = uf.find(accountIndex);

            mergedGroups.putIfAbsent(p, new ArrayList<>());
            mergedGroups.get(p).add(email); // Not sorted yet – Still need to sort
        }

        // Place the merged groups into the correct format + Sort emails
        List<List<String>> sol = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> e : mergedGroups.entrySet()) {
            int accountIndex = e.getKey();

            List<String> emails = e.getValue();
            Collections.sort(emails);

            emails.add(0, accounts.get(accountIndex).get(0)); // Add name to beginning

            sol.add(emails);
        }
        return sol;
    }
}