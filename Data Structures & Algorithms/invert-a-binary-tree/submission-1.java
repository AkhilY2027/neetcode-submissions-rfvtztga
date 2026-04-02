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
    public void dfsInvert(TreeNode cur) {
        if (cur == null) return;

        // Traverse first
        dfsInvert(cur.left);
        dfsInvert(cur.right);

        // Switch
        TreeNode temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
        return;
    }
    public TreeNode invertTree(TreeNode root) {
        // Order: Traverse left, then traverse right, then invert current node
        dfsInvert(root);
        return root;
    }
}
