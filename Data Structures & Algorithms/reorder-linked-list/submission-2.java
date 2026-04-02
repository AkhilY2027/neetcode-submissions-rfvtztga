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
        // Need to go halfway first to get to the nodes we need to rearrange
            // Then what?

        // Maybe we can go halfway and store the next nodes in a stack?
            // Then, "pop" out the stack on a new run
        
        // 1. Get length of list
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        // 2. Traverse half of list and put other half into a stack
        int half = (n + 1) / 2;
        cur = head;
        while (half > 0) {
            half--;
            cur = cur.next;
        }
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        // 3. Do a new run where we add these numbers into the stack
        cur = head;
        while (!stack.isEmpty()) {
            ListNode toAdd = stack.pop();
            toAdd.next = cur.next;
            cur.next = toAdd;
            cur = cur.next.next;
        }
        // In case of odd number, want to ensure last element's next is removed
        if (cur != null)
            cur.next = null;
    }
}
