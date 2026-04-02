/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private void createNode(Node copy, Node node, HashMap<Integer, Node> valMap, HashSet<Integer> visited) {
        if (visited.contains(node.val)) return;

        // Should have already created copy of current node – mark as visited
        visited.add(node.val);

        // Create neighbor nodes
        for (Node i : node.neighbors) {
            if (!valMap.containsKey(i.val)) {
                Node newNeighbor = new Node(i.val);
                valMap.put(i.val, newNeighbor);
                copy.neighbors.add(newNeighbor);
            }
            else copy.neighbors.add(valMap.get(i.val));
        }

        // Recurse on each node
        for (int i = 0; i < copy.neighbors.size(); i++) {
            createNode(copy.neighbors.get(i), node.neighbors.get(i), valMap, visited);
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Integer, Node> valMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        Node solNode = new Node(node.val);
        valMap.put(node.val, solNode);
        createNode(solNode, node, valMap, visited);
        return solNode;
    }
}