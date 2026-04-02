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
    public List<Integer> rightSideView(TreeNode root) {
        // Basically, the rightmost of every tree
            // Oh wait, if the left side is larger than the right, then some of the left have to be there as well
        
        // Do a BFS – for each level, want the rightmost element
            // This way, easier to keep track of that element than a dfs
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        List<Integer> sol = new ArrayList<>();
        if (root == null) return sol;
        while (!bfs.isEmpty()) {
            // For each level, find rightmost + add children
            int n = bfs.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = bfs.poll();
                if (i == n - 1) sol.add(cur.val);
                if (cur.left != null) bfs.add(cur.left);
                if (cur.right != null) bfs.add(cur.right);
            }
        }
        return sol;
    }
}
