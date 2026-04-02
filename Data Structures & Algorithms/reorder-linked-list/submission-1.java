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
    public void reorderList(ListNode head) {
        // HashMap<Integer, ListNode> nodeMap = new HashMap<>();
        // int n = 0;
        // ListNode cur = head, toAdd = null;
        // while (cur != null) {
        //     n++;
        //     nodeMap.put(cur.val, cur);
        //     cur = cur.next;
        // }

        // // Now, rearrage
        // for (int i = 0; i < n / 2; i++) {
        //     // For each one, get n - i - 1 and then add in between
        //     cur = nodeMap.get(i);
        //     toAdd = nodeMap.get(n - i - 1);
        //     toAdd.next = cur.next;
        //     cur.next = toAdd;
        // }

        // Use two pointers
            // Essentially, want to merge beginning of list with end of list – however, hard to traverse backwards through list
            // So reverse second half of list and use pointers going forward
                // Use slow and fast pointer to find midpoint of list (when fast reaches end, slow is at middle)
        if (head == null) return;
        
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) { // End at end of list/when null
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half of list – Will separate it into its own list
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (secondHalf != null) {
            ListNode next = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = next;
        }

        // Now, interleave
        ListNode curNode = head;
        secondHalf = prev; // Get the "end" of the list/beginning of reversed second half
        while (secondHalf != null) {
            ListNode firstNext = curNode.next;
            ListNode secondNext = secondHalf.next;
            curNode.next = secondHalf;
            secondHalf.next = firstNext;
            curNode = firstNext;
            secondHalf = secondNext;
        }
    }
}
