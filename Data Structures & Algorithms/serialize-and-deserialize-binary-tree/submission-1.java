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

public class Codec {

    private String serializeDfs(TreeNode cur) {
        if (cur == null) {
            return "|";
        }
        String str = Integer.toString(cur.val);
        return str + "," + serializeDfs(cur.left) + "," + serializeDfs(cur.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeDfs(root);
    }

    private TreeNode deserializeDfs(String[] parts, int[] i) {
        if (parts[i[0]].equals("|")) {
            i[0]++;
            return null;
        }

        TreeNode cur = new TreeNode(Integer.parseInt(parts[i[0]]));
        i[0]++;
        cur.left = deserializeDfs(parts, i);
        cur.right = deserializeDfs(parts, i);
        return cur;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] treeParts = data.split(",");
        if (treeParts[0].equals("|")) return null;
        int[] i = {0}; // Have a pointer to whereever we are in the array
        return deserializeDfs(treeParts, i);
    }
}
