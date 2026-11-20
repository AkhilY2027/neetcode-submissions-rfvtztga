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
    public ListNode reverseList(ListNode head) {
        ListNode sol = new ListNode();

        // For every node, insert it to the right of sol
        while (head != null) {
            ListNode nextHead = head.next;
            head.next = sol.next;
            sol.next = head;
            head = nextHead;
        }
        return sol.next;
    }
}
