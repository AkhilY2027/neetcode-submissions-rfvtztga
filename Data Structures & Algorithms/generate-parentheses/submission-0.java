class Solution {
    // public boolean checkPar(String s) {
    //     Stack<String> stack = new Stack<>();
    //     for (char c : s.toCharArray()) {
    //         if (c == ')') {
    //             if (stack.peek() != ')')
    //                 return false;
    //             else
    //                 stack.pop();
    //         }
    //         else
    //             stack.push(c);
    //     }
    //     if (!stack.isEmpty())
    //         return false;
    //     return true;
    // }

    public void recur(List<String> l, int numLeft, int numRight, int rightNeeded, String s) {
        // Base Case -- All Satisfied
        if (numLeft == 0 && numRight == 0) {
            l.add(s);
            return;
        }

        // Basically, build out the string here
        // Either a left or a right

        // Choose:
        // Choosing a right
        if (rightNeeded > 0) {
            s += ')';
            recur(l, numLeft, numRight - 1, rightNeeded - 1, s);
            s = s.substring(0, s.length() - 1);
        }
        // Choosing a left
        if (rightNeeded < numRight) {
            s += '(';
            recur(l, numLeft - 1, numRight, rightNeeded + 1, s);
            s = s.substring(0, s.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> posStrings = new ArrayList<>();

        // Solution 1: Manually generate all possible options and then check if they work?
            // Problems: How to generate all solutions without repeats?
        // Solution 2: Manually place?
        recur(posStrings, n, n, 0, "");
        return posStrings;
    }
}
