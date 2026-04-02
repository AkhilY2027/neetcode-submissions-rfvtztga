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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Intuition: Can reverse the problem to say: Find the size - nth node from beginning and remove it

        // 1. Find the total size of the linkedlist
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }

        // 2. Find the specific node and remove it
        int found = size - n;
        cur = head;
        ListNode prev = null;
        while (found != 0) {
            prev = cur;
            cur = cur.next;
            found--;
        }
        if (prev == null) return cur.next;
        else {
            prev.next = cur.next;
            return head;
        }
    }
}
