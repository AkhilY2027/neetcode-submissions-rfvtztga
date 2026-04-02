/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Can nodes repeat in value?
            // If not, then we can use a hashmap to store
            // Even better: Use the "old" node as key for "new" node
        
        // Two-Pass Algorithm with Hashmap: (Easiest)
        HashMap<Node, Node> oldToNew = new HashMap<>();

        // 1. Copy all existing nodes
        Node curNode = head;
        while (curNode != null) {
            oldToNew.put(curNode, new Node(curNode.val));
            curNode = curNode.next;
        }
        oldToNew.put(null, null);

        // 2. Add Next and Random pointers to each one
        curNode = head;
        while (curNode != null) {
            oldToNew.get(curNode).next = oldToNew.get(curNode.next);
            oldToNew.get(curNode).random = oldToNew.get(curNode.random);
            curNode = curNode.next;
        }

        // Now, return head of new list – all in order
        return oldToNew.get(head);
    }
}
