class Solution {
    public int calPoints(String[] operations) {
        // // Brute Force, calculate all:
        // ArrayList<Integer> scores = new ArrayList<>();
        // for (String op : operations) {
        //     if (op.equals("+"))
        //         scores.add(scores.get(scores.size() - 1) + scores.get(scores.size() - 2));
        //     else if (op.equals("D"))
        //         scores.add(2 * scores.get(scores.size() - 1));
        //     else if (op.equals("C"))
        //         scores.remove(scores.size() - 1);
        //     else
        //         scores.add(Integer.parseInt(op));
        // }

        // // Calculate sum
        // int sol = 0;
        // for (int i = 0; i < scores.size(); i++)
        //     sol += scores.get(i);
        // return sol;

        // For better optimization, use a stack
            // Also, calculate sum as we're going through the operations
        Stack<Integer> scores = new Stack<>();
        int sol = 0;
        for (String op : operations) {
            if (op.equals("+")) {
                int prev = scores.pop();
                int cur = scores.peek() + prev;
                scores.push(prev);
                scores.push(cur);
                sol += cur;
            }
            else if (op.equals("D")) {
                int cur = scores.peek() * 2;
                scores.push(cur);
                sol += cur;
            }
            else if (op.equals("C")) {
                sol -= scores.pop();
            }
            else {
                int cur = Integer.parseInt(op);
                scores.push(cur);
                sol += cur;
            }
        }
        return sol;
    }
}