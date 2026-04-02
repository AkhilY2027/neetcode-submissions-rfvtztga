class Solution {
    private boolean dfs(char c, HashMap<Character, HashSet<Character>> charMap, HashMap<Character, Boolean> visited, ArrayList<Character> toBuild) {
        if (visited.containsKey(c)) return visited.get(c); // If we have encountered c in another dfs cycle, this should be false
        visited.put(c, true);

        for (char n : charMap.get(c))
            if (dfs(n, charMap, visited, toBuild))
                return true;
        
        visited.put(c, false);
        toBuild.add(c);
        return false;
    }
    public String foreignDictionary(String[] words) {
        // Have to make sense of order based on the sorted dictionary
            // Basically, you know from relations what letters are greater and lesser between each other
        
        // Intuition: We can know the relationship between individual letters easily by looking through words
            // However, cannot know between letters – need to have kind of a map to continuously explore the relationship
            // Almost like a graph
            // Yes, this is dfs
        
        // Maps each character to what comes after them
        HashMap<Character, HashSet<Character>> charMap = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            for (char c : words[i].toCharArray())
                charMap.putIfAbsent(c, new HashSet<>());
        
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int rangeToCompare = Math.min(word1.length(), word2.length());

            if (word1.substring(0, rangeToCompare).equals(word2.substring(0, rangeToCompare))
                && word1.length() > word2.length())
                return ""; // Order invalid

            for (int j = 0; j < rangeToCompare; j++) {
                if (word1.charAt(j) != word2.charAt(j)) { // Lexigrahical difference
                    charMap.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        // Now, do a post order dfs to get all the children
            // Should be children first then parent so we can reverse after
            // Easier to do this to find all the children in correct order first
        
        // Three states:
            // Either actually haven't visited, so not in map
            // Have visited during one cycle of dfs, so true and we return normally
            // Have visited but in another cycle of dfs – should not happen (Order is invalid)
        HashMap<Character, Boolean> visited = new HashMap<>();
        ArrayList<Character> toBuild = new ArrayList<>();

        for (char c : charMap.keySet()) // Starting at any point is fine 
            if (dfs(c, charMap, visited, toBuild))
                return "";
        
        Collections.reverse(toBuild);
        StringBuilder sol = new StringBuilder();
        for (char c : toBuild)
            sol.append(c);
        return sol.toString();
    }
}
