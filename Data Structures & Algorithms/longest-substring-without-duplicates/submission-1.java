class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        int sol = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            while (charMap.get(c) > 1) {
                char lc = s.charAt(l);
                charMap.put(lc, charMap.get(lc) - 1);
                l++;
            }
            sol = Math.max(r - l + 1, sol);
            r++;
        }
        return sol;
    }
}
