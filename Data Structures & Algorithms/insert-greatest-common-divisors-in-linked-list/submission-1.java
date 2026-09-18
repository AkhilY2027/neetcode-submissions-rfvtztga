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
    private int gcd(int x, int y) {
        // Essentially, continously dividing x by y and getting its remainder
            // Then, doing the same for y and the remainder
            // When this division is 0, it means we pruned off all excess factors
        while (y > 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) return null;

        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            // 1. Find gcd between prev and cur
            int gcd = gcd(prev.val, cur.val);

            // 2. Insert in between the two nodes
            prev.next = new ListNode(gcd, cur);
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}