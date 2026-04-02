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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> temp;

        if (root == null) return sol;

        // Do BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // Check each level
            temp = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                // Add each node on this level + Add the value to the list
                TreeNode curNode = q.poll();
                temp.add(curNode.val);
                if (curNode.left != null) q.add(curNode.left);
                if (curNode.right != null) q.add(curNode.right);
            }
            sol.add(temp);
        }

        return sol;
    }
}
