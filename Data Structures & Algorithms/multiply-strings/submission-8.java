class Solution {
    public String multiply(String num1, String num2) {
        // int num1Integer = 0;
        // for (char c : num1.toCharArray()) {
        //     // System.out.println("Char: " + c);
        //     // System.out.println("Num: " + (c - '0'));
        //     num1Integer = num1Integer * 10 + (c - '0');
        // }
        // System.out.println("Num1: " + num1Integer);
        // int num2Integer = 0;
        // for (char c : num2.toCharArray()) {
        //     num2Integer = num2Integer * 10 + (c - '0');
        // }
        // System.out.println("Num2: " + num2Integer);
        // long mul = num1Integer * num2Integer;
        // System.out.println("Mul: " + mul);
        // if (mul == 0) return "0";
        // // Convert mul into string
        // String sol = "";
        // while (mul > 0) {
        //     char curNum = '0';
        //     curNum += mul % 10;
        //     System.out.println("Char: " + curNum);
        //     sol = curNum + sol;
        //     mul /= 10;
        // }
        // return sol;
        
        // Possibility that num won't even be able to be stored within a long
            // Use an array instead
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] res = new int[num1.length() + num2.length()];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        // Now, manually multiply
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                // Get each potential digit
                int digit = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j] += digit;
                res[i + j + 1] += res[i + j] / 10;
                res[i + j] %= 10;
            }
        }

        // Now, build
        StringBuilder sol = new StringBuilder();
        int buildIndex = res.length - 1;
        while (buildIndex >= 0 && res[buildIndex] == 0) buildIndex--;
        while (buildIndex >= 0) sol.append(res[buildIndex--]); // Multiplied in reverse so that we can build properly (since we build from the beginning and add)
        return sol.toString();
    }
}
