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
        if (head == null) return null;
        
        // Node sol = new Node(head.val);
        // Node curSol = sol;
        // HashMap<Integer, Node> found = new HashMap<>();
        // found.put(sol.val, sol);
        // while(head != null) {
        //     // Add random node
        //     if (head.random != null) {
        //         if (found.containsKey(head.random.val)) curSol.random = found.get(head.random.val);
        //         else {
        //             curSol.random = new Node(head.random.val);
        //             found.put(curSol.random.val, curSol.random);
        //         }
        //     }

        //     // Add next node
        //     if (head.next == null) break;
        //     if (found.containsKey(head.next.val)) curSol.next = found.get(head.next.val);
        //     else {
        //         curSol.next = new Node(head.next.val);
        //         found.put(curSol.next.val, curSol.next);
        //     }

        //     // Iterate through
        //     head = head.next;
        //     curSol = curSol.next;
        // }
        // return sol;

        HashMap<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(null, null); // In case we encounter a null pointer
        Node cur = head; // To loop through the orig linkedlist
        while (cur != null) {
            if (!oldToNew.containsKey(cur)) oldToNew.put(cur, new Node(0)); // Because we know on each iteration we're either creating a new node or filling it with the needed value
            oldToNew.get(cur).val = cur.val; // Want to do it here because next and random pointers could point to null, so easy to way to not program too much

            // Next
            if (!oldToNew.containsKey(cur.next)) oldToNew.put(cur.next, new Node(0));
            oldToNew.get(cur).next = oldToNew.get(cur.next);

            // Random
            if (!oldToNew.containsKey(cur.random)) oldToNew.put(cur.random, new Node(0));
            oldToNew.get(cur).random = oldToNew.get(cur.random);

            // Iterate
            cur = cur.next;
        }
        return oldToNew.get(head);
    }
}
