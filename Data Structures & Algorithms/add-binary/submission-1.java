class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sol = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int ai = 0;
            if (i >= 0) {
                ai = a.charAt(i) - '0';
                i--;
            }
            
            int bj = 0;
            if (j >= 0) {
                bj = b.charAt(j) - '0';
                j--;
            }

            sol.append((char) ('0' + ((ai + bj + carry) % 2)));
            carry = (ai + bj + carry) / 2;
        }
        
        // Add last carry
        if (carry == 1)
            sol.append('1');
        
        return sol.reverse().toString();
    }
}