class Solution {
    public String decodeString(String s) {
        // Either use stacks or recursion

        // Stack version
            // Keep a track of the strings that we've found + the numbers to repeat them
            // Use a StringBuilder to record current string and an empty number to record the digits for repetition
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder curString = new StringBuilder();
        int curNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                curNum = curNum * 10 + (c - '0');
            else if (c == '[') {
                // Place current String so far onto the stringStack
                stringStack.push(curString.toString());
                countStack.push(curNum);

                // Reset these two, as they have been recorded
                curString = new StringBuilder();
                curNum = 0;
            }
            else if (c == ']') {
                // Need to repeat based on number
                String toRepeat = curString.toString();
                curString = new StringBuilder(stringStack.pop()); // prefix that we don't need to repeat
                int r = countStack.pop();
                for (int i = 0; i < r; i++)
                    curString.append(toRepeat);
            }
            else
                curString.append(c);
        }

        return curString.toString();
    }
}