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
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> set = new HashSet<>();
        walk(candidates, 0, target, new ArrayList<Integer>(), set);
        return new ArrayList<List<Integer>>(set);
    }
}
