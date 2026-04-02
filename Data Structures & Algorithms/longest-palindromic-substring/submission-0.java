class Solution {
    public String longestPalindrome(String s) {
        String sol = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                else
                    break;
            }
            l++;
            r--;
            if (sol.length() < (r - l + 1)) {
                sol = s.substring(l, r + 1);
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                else
                    break;
            }
            l++;
            r--;
            if (sol.length() < (r - l + 1)) {
                sol = s.substring(l, r + 1);
            }
        }
        return sol;
    }
}
