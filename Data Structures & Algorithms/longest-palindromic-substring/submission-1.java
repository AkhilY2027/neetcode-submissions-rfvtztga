class Solution {
    public String longestPalindrome(String s) {
        String sol = "";
        for (int i = 0; i < s.length(); i++) {
            // Checking for odd length palindromes
            int l = i, r = i;
            // while (l >= 0 && r < s.length()) {
            //     if (s.charAt(l) == s.charAt(r)) {
            //         l--;
            //         r++;
            //     }
            //     else
            //         break;
            // }
            // l++;
            // r--;
            // if (sol.length() < (r - l + 1)) {
            //     sol = s.substring(l, r + 1);
            // }
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (sol.length() < (r - l + 1))
                    sol = s.substring(l, r + 1);
                l--;
                r++;
            }

            // Even length palindromes
            l = i;
            r = i + 1;
            // while (l >= 0 && r < s.length()) {
            //     if (s.charAt(l) == s.charAt(r)) {
            //         l--;
            //         r++;
            //     }
            //     else
            //         break;
            // }
            // l++;
            // r--;
            // if (sol.length() < (r - l + 1)) {
            //     sol = s.substring(l, r + 1);
            // }
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (sol.length() < (r - l + 1))
                    sol = s.substring(l, r + 1);
                l--;
                r++;
            }
        }
        return sol;
    }
}
