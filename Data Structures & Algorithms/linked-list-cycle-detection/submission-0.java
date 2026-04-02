/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            // System.out.println("ListNode: " + node);
            if (set.contains(node)) return true;
            set.add(node);
            node = node.next;
        }
        return false;
    }
}
