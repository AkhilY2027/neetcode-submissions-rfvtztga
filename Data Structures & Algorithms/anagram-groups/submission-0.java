class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. Sort string array by length of strings (smallest -> largest)
        // 2. In each section of count, check if any are anagrams
            // Group those together

        // Can get anagram if all letters are same, meaning:
            // We either sort or we count chars
        // int[][] freqArrays = new int[strs.length][26];

        // Optimization: Use a hashmap to connect char[26] array to words
            // So multiple words with same char count will be in the same bucket
            // Thus, can easily convert hashmap into array later
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                count[strs[i].charAt(j) - 'a']++;
            }
            // Can convert the array into a string to make key comparisons easier
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());

        // // Check which freq arrays are correct
        // List<List<String>> masterList = new ArrayList<>();
        // int[] countArr = new int[freqArrays.length];
        // for (int i = 0; i < strs.length; i++) {
        //     List<String> minorList = new ArrayList<>();
        //     minorList.add();
        // }
        // return masterList;
    }
}
