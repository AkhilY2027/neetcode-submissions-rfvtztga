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
    public int dfs(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return depth;
        }
        return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
    }
    public int maxDepth(TreeNode root) {
        // Isn't this just a dfs?
        // return dfs(root, 1);

        // Just for reference, an iterative DFS:
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));

        int res = 0;
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> curPair = stack.pop();
            TreeNode curNode = curPair.getKey();
            int curDepth = curPair.getValue();
            
            if (curNode != null) {
                res = Math.max(res, curDepth);
                stack.push(new Pair<>(curNode.left, curDepth + 1));
                stack.push(new Pair<>(curNode.right, curDepth + 1));
            }
        }
        return res;
    }
}
