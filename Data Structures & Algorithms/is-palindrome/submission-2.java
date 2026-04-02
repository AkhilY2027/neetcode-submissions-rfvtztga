class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int a = 0;
        int b = len - 1;
        while(a < len && !Character.isLetterOrDigit(s.charAt(a))) {
            a++;
        }
        if (a >= len) return true;
        while(b >= 0 && !Character.isLetterOrDigit(s.charAt(b))) {
            b--;
        }
        if (b < 0) return true;
        while (a <= b) {
            if (Character.toLowerCase(s.charAt(a)) != Character.toLowerCase(s.charAt(b)))
                return false;
            a++;
            b--;
            while(a < len && !Character.isLetterOrDigit(s.charAt(a))) {
                a++;
            }
            if (a >= len) return true;
            while(b >= 0 && !Character.isLetterOrDigit(s.charAt(b))) {
                b--;
            }
            if (b < 0) return true;
        }
        return true;
    }
}
