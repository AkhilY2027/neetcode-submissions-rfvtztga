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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Basically, do a search
        // Ancestor is where p and q will be on opposite sides of the tree
            // Have p be the lesser element and q be the greater element
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        // Then, search
        TreeNode cur = root;
        while (cur != null) {
            if (p.val <= cur.val && cur.val <= q.val) {
                // Found our ancestor as p and q are on opposite sides
                return cur;
            }
            else if (p.val <= cur.val && q.val <= cur.val) {
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }

        return root;
    }
}
