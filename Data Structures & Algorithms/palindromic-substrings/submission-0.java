class Solution {
    public boolean checkPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n / 2; i++)
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;

        return true;
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int sol = 0;
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                if (checkPalindrome(s.substring(start, start + len)))
                    sol++;
            }
        }
        return sol;
    }
}
