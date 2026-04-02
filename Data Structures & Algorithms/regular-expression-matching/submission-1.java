class Solution {
    public boolean backTrack(Boolean[][] cache, String s, String p, int i, int j) {
       if (j >= p.length()) return i >= s.length();
        if (cache[i][j] != null) return cache[i][j];

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        // Now, check for stars
        // if (j + 1 < p.length() && p.charAt(j + 1) == '*') return backTrack(s, p, i, j + 2) || (match && backTrack(s, p, i + 1, j));
        //     // Either don't use the star or use star (Current variables must already be matching at this point or star is already not working)
        // if (match) return backTrack(s, p, i + 1, j + 1);
        // return false;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*')
            cache[i][j] = backTrack(cache, s, p, i, j + 2) || (match && backTrack(cache, s, p, i + 1, j));
        else cache[i][j] = match && backTrack(cache, s, p, i + 1, j + 1);

        return cache[i][j];
    }

    public boolean isMatch(String s, String p) {
        // . just has to match any character
        // * has to fulfill two conditions:
            // Basically, find repeats of the previous char
            // Do this until the next char in line has been reached/end of string
        // int index1 = 0, index2 = 0;
        // while(index1 < s.length()) {
        //     // Basically, check what index in the pattern we're on and decide from there
        //     char sChar = s.charAt(index1);
        //     char pChar = p.charAt(index2);
        //     if (pChar == '*') {
        //         // The big one
        //         if (index2 == 0) return false; // Cannot have this in the first element
        //         char prevChar = p.charAt(index2 - 1);
        //         // char untilChar = p. - Don't worry about this for now
        //     }
        //     else {
        //         if (pChar != '.' && (sChar != pChar)) return false;
        //         index1++;
        //         index2++;
        //     }
        // }
        // return index2 == p.length();

        // Star makes everything a decision tree (whether to use char 0, 1, 2, etc. times)
            // Would usually use recursion for this, but can thus use dp for it
            // Basically, just add a cache

        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];

        return backTrack(dp, s, p, 0, 0);
    }
}
