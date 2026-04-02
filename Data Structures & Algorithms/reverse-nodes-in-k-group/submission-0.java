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
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        int groups = count / k;
        ListNode tempTail = null, tempHead = null, sol = new ListNode(), solCur = sol;
        cur = head;
        for (int i = 0; i < groups; i++) {
            tempTail = null;
            tempHead = null;
            for (int j = 0; j < k; j++) {
                // Iterate k times through
                ListNode next = cur.next;
                if (tempTail == null) {
                    tempHead = cur;
                    tempTail = cur;
                    cur.next = null;
                }
                else {
                    cur.next = tempHead;
                    tempHead = cur;
                }
                cur = next;
            }
            solCur.next = tempHead;
            solCur = tempTail;
        }
        solCur.next = cur;

        return sol.next;
    }
}
