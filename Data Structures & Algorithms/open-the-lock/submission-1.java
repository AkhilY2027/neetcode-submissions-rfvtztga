class Solution {
    private List<String> combos(String curLock) {
        List<String> sol = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] arr = curLock.toCharArray();
            arr[i] = (char) (((arr[i] - '0' + 1) % 10) + '0');
            sol.add(new String(arr));

            arr = curLock.toCharArray();
            arr[i] = (char) (((arr[i] - '0' - 1 + 10) % 10) + '0');
            sol.add(new String(arr));
        }
        return sol;
    }
    public int openLock(String[] deadends, String target) {
        // Want to change each of the characters to the target, moving one at a time
            // So either go forward in wheel (0, 1, 2, ...) or backward (0, 9, 8, ...)
            // Deadends can be avoided usually by turning another character before our own
                // In what situation would a deadend exist?

        // Cannot actually greedy brute force this due to deadend being always present
            // Instead, need to manually calculate all possible paths
            // Easy way to do this is via a bfs
        
        // 1. Put deadends into hashset
        HashSet<String> ends = new HashSet<>();
        for (String de : deadends)
            ends.add(de);

        // 2. Do a bfs of all combinations starting from 0000
            // If we find a combination thats a dead end, "prune" it
        Queue<String> combinations = new LinkedList<>();
        HashSet<String> visited = new HashSet<>(); // Ensuring that we don't repeat work
        combinations.add("0000");
        visited.add("0000");
        int sol = 0;
        while (!combinations.isEmpty()) {
            int n = combinations.size();
            for (int i = 0; i < n; i++) {
                String cur = combinations.poll();
                if (cur.equals(target))
                    return sol;
                if (ends.contains(cur))
                    continue;

                for (String next : combos(cur)) {
                    if (!visited.contains(next)) {
                        combinations.add(next);
                        visited.add(next);
                    }
                }
            }
            sol++;
        }
        return -1;
    }
}