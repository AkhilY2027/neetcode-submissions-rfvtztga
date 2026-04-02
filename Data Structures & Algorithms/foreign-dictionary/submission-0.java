class Solution {
    public boolean dfs(char c, HashMap<Character, Boolean> visited, HashMap<Character, HashSet<Character>> map, ArrayList<Character> build) {
        if (visited.containsKey(c))
            return visited.get(c);

        visited.put(c, true);

        for (char neighbor : map.get(c)) {
            if (dfs(neighbor, visited, map, build))
                return true;
        }

        // Before we return
        visited.put(c, false);
        build.add(c);
        return false;
    }
    public String foreignDictionary(String[] words) {
        // Create a map of letters to what letters are greater than them
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        // First, create one for every character within our dictionary - to output
        for (int i = 0; i < words.length; i++) {
            for (char c: words[i].toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            // Compare every two words and find what makes them different
            String word1 = words[i];
            String word2 = words[i + 1];
            int maxPossiblePrefix = Math.min(word1.length(), word2.length());
            if (word1.substring(0, maxPossiblePrefix).equals(word2.substring(0, maxPossiblePrefix)) && word1.length() > word2.length())
                return "";
            for (int j = 0; j < maxPossiblePrefix; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    // Found the difference - Note the relation
                    map.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        // Then, do a post-order DFS to get all children
            // This is how topological sort is done - DFS but in reverse order
        
        // Use a map to keep track of visited characters
            // Three Possibilities:
            // 1. Not in map (not visited)
            // 2. False (Visited before)
            // 3. True (In current path - cycle detected)
        HashMap<Character, Boolean> visited = new HashMap<>();
        ArrayList<Character> build = new ArrayList<>();

        // Call post-order dfs at all points
        for (char c: map.keySet()) {
            if (dfs(c, visited, map, build))
                return "";
        }
        Collections.reverse(build);
        StringBuilder sol = new StringBuilder();
        for (char c : build) {
            sol.append(c);
        }
        return sol.toString();
    }
}
