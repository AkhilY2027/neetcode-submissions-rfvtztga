class Solution {
    private int calculateCharIndex(char c) {
        if (Character.isUpperCase(c)) return c - 'A';
        else return c - 'a' + 26;
    }
    
    private boolean compareStoT(int[] sChars, int[] tChars) {
        for (int i = 0; i < sChars.length; i++)
            if (tChars[i] > sChars[i]) return false;
        return true;
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        // // 1. Calculate the numbers of characters within t
        // int[] tChars = new int[52];
        // for (char c : t.toCharArray())
        //     tChars[calculateCharIndex(c)]++;
        
        // // System.out.println(Arrays.toString(tChars));

        // // 2. Do a sliding window for s and find a substring that works
        // String sol = "";
        // int[] sChars = new int[52];
        // int l = 0, r = 0;
        // while (r < s.length()) {
        //     // Add r to sChars
        //     sChars[calculateCharIndex(s.charAt(r))]++;

        //     // System.out.println(Arrays.toString(sChars));

        //     // Found our substring?
        //     while (compareStoT(sChars, tChars)) {
        //         // System.out.println("Got into while loop");
        //         if (sol.isEmpty() || sol.length() > (r - l + 1))
        //             sol = s.substring(l, r + 1);

        //         // Remove l and see if it still works
        //         sChars[calculateCharIndex(s.charAt(l))]--;
        //         l++;
        //     }
        //     r++;
        // }
        // return sol;

        // Optimization: Have a variable to represent how many unique characters we find in t
            // + use a check variable to see how many in the s substring perfectly matches to t
        if (t.isEmpty()) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        int tReqs = tMap.size();

        // Go through s
        String sol = "";
        HashMap<Character, Integer> sMap = new HashMap<>();
        int sMatches = 0, l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if (tMap.containsKey(c) && sMap.get(c) == tMap.get(c)) sMatches++;

            // Found a substring
            while (sMatches == tReqs) {
                if (sol.isEmpty() || sol.length() > (r - l + 1)) sol = s.substring(l, r + 1);

                // Decrement an l
                char lc = s.charAt(l);
                sMap.put(lc, sMap.getOrDefault(lc, 0) - 1);
                if (tMap.containsKey(lc) && sMap.get(lc) == tMap.get(lc) - 1) sMatches--;
                l++;
            }

            r++;
        }
        return sol;
    }
}
