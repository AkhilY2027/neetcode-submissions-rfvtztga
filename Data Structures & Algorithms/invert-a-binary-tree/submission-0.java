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
    public TreeNode invertTree(TreeNode root) {
        // Do a BFS - Swap children nodes
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                if (cur == null) continue;
                
                // Swap children
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;

                // Add children
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return root;
    }
}
