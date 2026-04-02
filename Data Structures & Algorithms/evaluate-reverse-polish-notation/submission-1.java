class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+")) {
                // Add
                int num2 = nums.pop();
                int num1 = nums.pop();
                nums.push(num1 + num2);
            }
            else if (token.equals("-")) {
                // Sub
                int num2 = nums.pop();
                int num1 = nums.pop();
                nums.push(num1 - num2);
            }
            else if (token.equals("*")) {
                // Mul
                int num2 = nums.pop();
                int num1 = nums.pop();
                nums.push(num1 * num2);
            }
            else if (token.equals("/")) {
                // Div
                int num2 = nums.pop();
                int num1 = nums.pop();
                nums.push(num1 / num2);
            }
            else {
                // Add to stack
                nums.push(Integer.parseInt(token));
            }
        }
        return nums.pop();
    }
}
