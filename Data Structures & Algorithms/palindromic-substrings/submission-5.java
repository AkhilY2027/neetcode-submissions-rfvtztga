class Solution {
    public boolean checkPalindrome(String s) {
        // Just check the opposite part of the string
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }
        return true;
    }
    public int countSubstrings(String s) {
        // Brute Force: Find all substrings and see if they're palindromes
        // int count = 0;
        // for (int l = 2; l <= s.length(); l++) {
        //     for (int i = 0; i < s.length() - l + 1; i++) {
        //         if (checkPalindrome(s.substring(i, i + l))) count++;
        //     }
        // }
        // return count + s.length();

        // Optimization: Find palindromes by expanding left and right from every one/two-letter palindrome
            // This way, since each center is different, the palindromes are automatically different
        
        // One-letter
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }

        // Two-letter
        for (int i = 0; i < s.length() - 1; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }

        return count;
    }
}
