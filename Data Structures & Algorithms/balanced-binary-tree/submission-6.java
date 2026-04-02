/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int[] dfs(TreeNode node) {
        if (node == null) return new int[] {1, 0}; // Automatically balanced

        // Otherwise, compare the left and right subtrees
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        boolean balanced =
            (left[0] == 1 && right[0] == 1) && // Both need to be balanced subtrees
            (Math.abs(left[1] - right[1]) <= 1); // the heights match

        return new int[] {(balanced) ? 1 : 0, 1 + Math.max(left[1], right[1])};
    }
    public boolean isBalanced(TreeNode root) {
        // Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        // stack.push(new Pair<>(root, 1));
        // int heightFound = -1;
        // while (!stack.isEmpty()) {
        //     // Continuously add the children
        //     Pair<TreeNode, Integer> pair = stack.pop();
        //     TreeNode node = pair.getKey();
        //     int curHeight = pair.getValue();
        //     if(node == null) {
        //         // Count all of these
        //         if (heightFound == -1) heightFound = curHeight;
        //         else if (heightFound < curHeight - 1 || heightFound > curHeight + 1) return false;
        //         continue;
        //     }
        //     stack.push(new Pair<>(node.left, curHeight + 1));
        //     stack.push(new Pair<>(node.right, curHeight + 1));
        // }
        // return true;

        // Basically, dfs
            // On each layer, check if the subtree is balanced by comparing the heights of its left and right trees
            // Recursive
        return dfs(root)[0] == 1;
    }
}
