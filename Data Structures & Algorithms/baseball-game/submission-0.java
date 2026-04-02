class Solution {
    public int calPoints(String[] operations) {
        // Brute Force, calculate all:
        ArrayList<Integer> scores = new ArrayList<>();
        for (String op : operations) {
            if (op.equals("+"))
                scores.add(scores.get(scores.size() - 1) + scores.get(scores.size() - 2));
            else if (op.equals("D"))
                scores.add(2 * scores.get(scores.size() - 1));
            else if (op.equals("C"))
                scores.remove(scores.size() - 1);
            else
                scores.add(Integer.parseInt(op));
        }

        // Calculate sum
        int sol = 0;
        for (int i = 0; i < scores.size(); i++)
            sol += scores.get(i);
        return sol;
    }
}