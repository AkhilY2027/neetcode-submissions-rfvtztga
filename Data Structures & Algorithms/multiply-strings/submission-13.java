class Solution {
    public String multiply(String num1, String num2) {
        // int n1 = 0;
        // for (char c : num1.toCharArray())
        //     n1 = n1 * 10 + (c - '0');

        // int n2 = 0;
        // for (char c : num2.toCharArray())
        //     n2 = n2 * 10 + (c - '0');

        // long n3 = n1 * n2;
        // if (n3 == 0) return "0";
        // StringBuilder sb = new StringBuilder();
        // while (n3 != 0) {
        //     char curDigit = (char) (((int) n3 % 10) + '0');
        //     n3 /= 10;
        //     sb.append(curDigit);
        // }
        // return sb.reverse().toString();

        // Instead of trying to store within a long (which may not work), use an array instead
            // Thus, manually multiply each digit of num1 and num2 to calculate each individual digit of sol array
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] sol = new int[num1.length() + num2.length()];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        // Manually multiply
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int curDig = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // Have to put into sol first, then divide, because we are adding to whatever's in sol
                    // The carry is based on the new value of sol, not just the digit we calculate here
                sol[i + j] += curDig;
                sol[i + j + 1] += sol[i + j] / 10;
                sol[i + j] %= 10;
            }
        }

        // Build based on sol array
        StringBuilder solString = new StringBuilder();
        int i = sol.length - 1;
        while (i >= 0 && sol[i] == 0) i--;
        while (i >= 0) solString.append(sol[i--]); // Notice that we multiplied in reverse so we can build from the beginning and add
        return solString.toString();
    }
}
