class Solution {
    public boolean checkPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n / 2; i++)
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;

        return true;
    }

    public int countSubstrings(String s) {
        // Brute Force: O(n^3)
        // int n = s.length();
        // int sol = 0;
        // for (int len = 1; len <= n; len++) {
        //     for (int start = 0; start <= n - len; start++) {
        //         if (checkPalindrome(s.substring(start, start + len)))
        //             sol++;
        //     }
        // }
        // return sol;

        // Use two pointers
            // Instead of constantly checking for palindromes, make each letter the "middle" of a palidrome and check that way
            // Do the same for 2-letter substrings
            // O(n^2)
        
        int sol = 0;
        for (int i = 0; i < s.length(); i++) {
            // Expand and see what are there

            // 1-letter substrings
            int l = i, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                sol++;
                l--;
                r++;
            }

            // 2-letter substrings
            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                sol++;
                l--;
                r++;
            }
        }
        return sol;
    }
}
