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
        ListNode curNode1 = list1;
        ListNode curNode2 = list2;
        ListNode finalList = null;
        ListNode sol = null;
        while(curNode1 != null && curNode2 != null) {
            ListNode add = null;
            if (curNode1.val < curNode2.val) {
                add = curNode1;
                curNode1 = curNode1.next;
            }
            else {
                add = curNode2;
                curNode2 = curNode2.next;
            }
            if (finalList == null) sol = add;
            else finalList.next = add;
            finalList = add;
        }
        if (curNode1 != null) {
            if (finalList == null) return curNode1;
            else finalList.next = curNode1;
        }
        else {
            // Because only one list should be null at a time
            if (finalList == null) return curNode2;
            else finalList.next = curNode2;
        }
        return sol;
    }
}