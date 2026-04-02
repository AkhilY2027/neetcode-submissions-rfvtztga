class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // So long as they share one of the same characters, gcd will be that character at least

        // Observations: Length of gcd must be at least a factor of str1's length and str2's length
            // Can check whenever we find a factor like this, as they're probably very rare
        
        if (str1.length() < str2.length()) { // Ensure str1 always has the greater length
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        for (int i = str2.length(); i >= 1; i--) {
            // 1. Check if length is a factor of this or not
            if (str1.length() % i != 0 || str2.length() % i != 0)
                continue;
            
            // 2. Manually check if this substring can fulfill both str1 and str2
                // Do this via checking if the characters repeat – this way, don't have to check strings constantly
            boolean can = true;

            // str1
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) != str2.charAt(j % i)) {
                    can = false;
                    break;
                }
            }

            // str2
            for (int j = 0; j < str2.length(); j++) {
                if (str2.charAt(j) != str2.charAt(j % i)) {
                    can = false;
                    break;
                }
            }

            if (can)
                return str2.substring(0, i);
        }
        return "";
    }
}