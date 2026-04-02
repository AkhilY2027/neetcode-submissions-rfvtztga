class Solution {
    public void walk(int[] candidates, int curIndex, int curTarget, ArrayList<Integer> curCombo, HashSet<List<Integer>> totalCombos) {
        if (curTarget < 0) return;
        if (curTarget == 0) {
            totalCombos.add(new ArrayList<Integer>(curCombo));
            return;
        }
        if (curIndex >= candidates.length) return;

        // Basically, do each with or without the number
        curCombo.add(candidates[curIndex]);
        walk(candidates, curIndex + 1, curTarget - candidates[curIndex], curCombo, totalCombos);
        curCombo.remove(curCombo.size() - 1);

        // Without
        walk(candidates, curIndex + 1, curTarget, curCombo, totalCombos);
    }

    public void solRecur(int[] candidates, int curIndex, int curTarget, ArrayList<Integer> curCombo, ArrayList<List<Integer>> totalCombos) {
        // Actual Solution
        if (curTarget < 0) return;
        if (curTarget == 0) {
            totalCombos.add(new ArrayList<Integer>(curCombo));
            return;
        }
        if (curIndex >= candidates.length) return;

        // With
        // curCombo.add(candidates[curIndex]);
        // solRecur(candidates, curIndex + 1, curTarget - candidates[curIndex], curCombo, totalCombos);
        // curCombo.remove(curCombo.size() - 1);

        // // Instead of the Hashset, all we need to do is:
        //     // Whenever a number is NOT included, do not include duplicates of that number
        //         // So either including number and duplicates or eliminating 
        //     // This way, save on recursive calls
        // int newIndex = curIndex + 1;
        // while (newIndex < candidates.length && candidates[curIndex] == candidates[newIndex]) newIndex++;
        // solRecur(candidates, newIndex, curTarget, curCombo, totalCombos);

        // Apparently, the optimal way is this:
        for (int i = curIndex; i < candidates.length; i++) {
            if (i > curIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (curTarget - candidates[i] < 0) {
                break;
            }

            curCombo.add(candidates[i]);
            solRecur(candidates, i + 1, curTarget - candidates[i], curCombo, totalCombos);
            curCombo.remove(curCombo.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // O(n * 2^n) I think but with O(n * 2^n) space complexity
        Arrays.sort(candidates);
        // HashSet<List<Integer>> set = new HashSet<>();
        // walk(candidates, 0, target, new ArrayList<Integer>(), set);
        // return new ArrayList<List<Integer>>(set);

        // Actual sol - O(n) space complexity since we're only storing what we need
        ArrayList<List<Integer>> sol = new ArrayList<>();
        solRecur(candidates, 0, target, new ArrayList<Integer>(), sol);
        return sol;
    }
}
