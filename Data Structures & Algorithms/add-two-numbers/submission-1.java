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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Cur = l1;
        ListNode l2Cur = l2;
        ListNode sol = new ListNode();
        ListNode cur = sol;
        ListNode prev = null;
        int carry = 0;
        while(l1Cur != null || l2Cur != null) {
            // Add both if possible and then increment
            int sum = carry;
            if (l1Cur != null) sum += l1Cur.val;
            if (l2Cur != null) sum += l2Cur.val;

            // Add to the linkedlist we're making
            cur.val = sum % 10;
            carry = sum / 10;

            // Increment
            if (l1Cur != null) l1Cur = l1Cur.next;
            if (l2Cur != null) l2Cur = l2Cur.next;
            cur.next = new ListNode();
            prev = cur;
            cur = cur.next;
        }

        // If there is a remaining carry, add it to the listnode
            // Otherwise, take the listnode out
        if (carry != 0) {
            cur.val = carry;
        }
        else {
            prev.next = null;
        }
        
        return sol;
    }
}
