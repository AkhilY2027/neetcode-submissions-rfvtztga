class Solution {
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        // Basically, just use two pointer to go from ends of string to middle
            // However, upon a differing character, check if you can remove that character and still make the string
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                // Check if palindrome can be formed by excluding one of the letters
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            l++;
            r--;
        }
        return true;
    }
}