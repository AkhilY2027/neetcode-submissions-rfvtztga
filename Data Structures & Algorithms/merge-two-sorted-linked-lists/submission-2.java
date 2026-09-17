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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curList1 = list1;
        ListNode curList2 = list2;
        ListNode sol = new ListNode(-101);
        ListNode curSol = sol;
        while (curList1 != null && curList2 != null) {
            // Compare the two nodes, add the one that is lesser
            if (curList1.val < curList2.val) {
                ListNode next = curList1.next;
                curSol.next = curList1;
                curList1.next = null;
                curSol = curSol.next;
                curList1 = next;
            }
            else {
                ListNode next = curList2.next;
                curSol.next = curList2;
                curList2.next = null;
                curSol = curSol.next;
                curList2 = next;
            }
        }

        // Add remainder of lists onto curSol
        if (curList1 != null) {
            curSol.next = curList1;
        }
        else
            curSol.next = curList2;

        return sol.next;
    }
}