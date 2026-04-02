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
        ArrayList<ListNode> list = new ArrayList<>();

        // Store all references
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int indexToRemove = list.size() - n;
        if (indexToRemove == 0) {
            // The beginning of the list
            return list.size() > 1 ? list.get(1) : null;
        }
        else if (indexToRemove == list.size() - 1) {
            // The end of the list
            list.get(list.size() - 2).next = null;
        }
        else {
            // Beginning and end
            list.get(indexToRemove - 1).next = list.get(indexToRemove + 1);
        }
        return list.get(0);
    }
}
