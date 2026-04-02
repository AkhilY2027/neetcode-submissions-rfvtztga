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
    public boolean checkSubTree(TreeNode root, TreeNode subRoot) {
        // Do a dfs and both and check if they're the same tree
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;

        // Since the two values are correct, check children
        return checkSubTree(root.left, subRoot.left) && checkSubTree(root.right, subRoot.right);
    }

    public boolean checkRoot(TreeNode root, TreeNode subRoot) {
        // Do a BFS to check all nodes from root
        int val = subRoot.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode curNode = q.poll();
                if (curNode == null) continue;
                if (curNode.val == val)
                    if (checkSubTree(curNode, subRoot))
                        return true;
                q.add(curNode.left);
                q.add(curNode.right);
            }
        }
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return checkRoot(root, subRoot);
        // if (start.val == -1000) return false;

        // return checkSubTree(start, subRoot);

        // DFS

    }
}
