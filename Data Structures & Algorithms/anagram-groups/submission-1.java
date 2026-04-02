class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Two ways to compare: Character Count + Frequency of Letters
            // Thus, can sort by letters first then find anagrams in each grouping of letters
        
        // However, as an optimization, we can just compare character counts
            // Get the character count for each and compare against each other
                // Those that are the same should be a "key" for a specific list of values
            // Thus, HashMap is best here
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // 1. Get count of chars
            int[] chars = new int[26];
            for (char c : strs[i].toCharArray()) {
                chars[c - 'a']++;
            }
            String key = Arrays.toString(chars); // Convert to String for easier comparisons

            // 2. Compare similarities via the HashMap
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values()); // Convert set of ArrayLists to ArrayList of ArrayLists
    }
}
