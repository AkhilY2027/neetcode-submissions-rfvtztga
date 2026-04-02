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
    public boolean dfsCompare(TreeNode cur1, TreeNode cur2) {
        if (cur1 == null && cur2 == null) return true;
        if (cur1 == null || cur2 == null) return false;
        if (cur1.val != cur2.val) return false;

        return dfsCompare(cur1.left, cur2.left) && dfsCompare(cur1.right, cur2.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Do a dfs
        return dfsCompare(p, q);
    }
}
