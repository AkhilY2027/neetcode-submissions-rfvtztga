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
    private int dfs(TreeNode cur) {
        if (cur == null) return 0;

        int left = dfs(cur.left);
        int right = dfs(cur.right);

        if (left == -1 || right == -1) return -1;

        if (Math.abs(left - right) <= 1) return Math.max(left, right) + 1;
        else return -1;
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }
}
