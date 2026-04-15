class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> polStack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int num1 = polStack.pop();
                int num2 = polStack.pop();
                polStack.push(num2 + num1);
            }
            else if (token.equals("-")) {
                int num1 = polStack.pop();
                int num2 = polStack.pop();
                polStack.push(num2 - num1);
            }
            else if (token.equals("*")) {
                int num1 = polStack.pop();
                int num2 = polStack.pop();
                polStack.push(num2 * num1);
            }
            else if (token.equals("/")) {
                int num1 = polStack.pop();
                int num2 = polStack.pop();
                polStack.push(num2 / num1);
            }
            else {
                polStack.push(Integer.parseInt(token));
            }
        }
        return polStack.pop();
    }
}
