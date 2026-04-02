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

        // 1. Calculate the numbers of characters within t
        int[] tChars = new int[52];
        for (char c : t.toCharArray())
            tChars[calculateCharIndex(c)]++;
        
        // System.out.println(Arrays.toString(tChars));

        // 2. Do a sliding window for s and find a substring that works
        String sol = "";
        int[] sChars = new int[52];
        int l = 0, r = 0;
        while (r < s.length()) {
            // Add r to sChars
            sChars[calculateCharIndex(s.charAt(r))]++;

            // System.out.println(Arrays.toString(sChars));

            // Found our substring?
            while (compareStoT(sChars, tChars)) {
                // System.out.println("Got into while loop");
                if (sol.isEmpty() || sol.length() > (r - l + 1))
                    sol = s.substring(l, r + 1);

                // Remove l and see if it still works
                sChars[calculateCharIndex(s.charAt(l))]--;
                l++;
            }
            r++;
        }
        return sol;
    }
}
