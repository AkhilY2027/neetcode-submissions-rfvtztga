class Solution {
    public String longestPalindrome(String s) {
        // Go through each letter and make it the "middle" of the palindrome
        String sol = "";

        // One letter
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { // Found palindrome
                if (sol.length() < r - l + 1) sol = s.substring(l, r + 1);
                l--;
                r++;
            }
        }

        // Two letter
        for (int i = 0; i < s.length() - 1; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { // Found palindrome
                if (sol.length() < r - l + 1) sol = s.substring(l, r + 1);
                l--;
                r++;
            }
        }
        return sol;
    }
}
