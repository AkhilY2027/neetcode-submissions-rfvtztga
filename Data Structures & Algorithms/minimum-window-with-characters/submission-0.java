class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int letterRequirements = tMap.size();

        HashMap<Character, Integer> sMap = new HashMap<>();
        int currentLetters = 0;
        int l = 0, r = 0;
        int bestl = -1, bestr = -1;
        while (r < s.length()) {
            // 1. See if new substring has the required letters
                // Do this by seeing if adding this particular letter fills the requirements
            char c = s.charAt(r);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if (tMap.containsKey(c) && sMap.get(c) == tMap.get(c)) // Only increment on equals because substring can hold more than required
                currentLetters++;
            
            // 2. If currentLetters == letterRequirements, found a viable substring
                // Increment l until substring is as minimum as possible
                // Check if better than currently available substring
                // Increment l by 1 to make this non-viable once again (so while loop runs again)

            while (currentLetters == letterRequirements) {
                // System.out.println(r + ", " + l);
                if (bestl == -1 || (r - l) < (bestr - bestl)) {
                    bestl = l;
                    bestr = r;
                }

                // Remove the left character as we increment it out of the substring
                c = s.charAt(l);
                sMap.put(c, sMap.getOrDefault(c, 0) - 1);
                if (tMap.containsKey(c) && sMap.get(c) < tMap.get(c))
                    currentLetters--;
                l++;
            }
            
            // 3. Increment r by 1 so while loop repeats
            r++;
        }

        return bestl == -1 ? "" : s.substring(bestl, bestr + 1);
    }
}
