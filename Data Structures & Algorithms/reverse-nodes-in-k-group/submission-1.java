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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Just reverse the linkedlist k times
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        // For each "group" of k, we'll be reversing the linkedlist and adding it onto a new sol linkedlist
        int groups = count / k;
        ListNode tempHead = null, tempTail = null, sol = new ListNode(), curSol = sol;
        cur = head;
        for (int i = 0; i < groups; i++) {
            tempHead = null;
            tempTail = null;
            // tempHead and tempTail will keep a track of our new reversed linkedlist for this group of k
            for (int j = 0; j < k; j++) {
                ListNode next = cur.next;
                if (tempTail == null) {
                    // Since we're going in order, the first node we find in group will be the tail of reversed linkedlist
                    tempTail = cur;
                    tempHead = cur;
                    cur.next = null;
                }
                else {
                    // Tail has been set – meaning we now build backwards instead of forwards
                    cur.next = tempHead;
                    tempHead = cur;
                }
                cur = next;
            }
            curSol.next = tempHead;
            curSol = tempTail; // To jump to next group properly
        }
        curSol.next = cur; // Add all remaining nodes onto this reversed LinkedList

        return sol.next;
    }
}
