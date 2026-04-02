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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // // 1. Find the left Node – Can store previous
        //     // To make easier, add a previous node to the head
        // ListNode temp = new ListNode();
        // temp.next = head;
        // head = temp;

        // ListNode prevLeftNode = head;
        // ListNode leftNode = head.next;
        // int i = 1;
        // while (i != left) {
        //     prevLeftNode = leftNode;
        //     leftNode = leftNode.next;
        //     i++;
        // }

        // // 2. From left Node, traverse until the right Node
        //     // While doing so, have a copy of the reversed List that you are building
        //     // Then, Replace left Node to right Node with reversed list
        // ListNode reversedList = null;
        // ListNode cur = leftNode;
        // while (i <= right) {
        //     ListNode nextNode = cur.next;
        //     cur.next = reversedList;
        //     reversedList = cur;
        //     cur = nextNode;
        //     i++;
        // }
        // leftNode.next = cur.next; // This way, we are connecting reversedList (where leftNode is the tail) back to the original list
        // cur.next = reversedList;
        // reversedList = cur;
        // prevLeftNode.next = reversedList;

        // return head.next;

        // 1. Get the node right before our leftNode so we know our initial starting point before reversing the next nodes
            // Can simplify edge cases by adding a new node as the head in case left is the first node
        ListNode newHead = new ListNode();
        newHead.next = head;

        ListNode prevLeft = newHead;
        for (int i = 1; i < left; i++)
            prevLeft = prevLeft.next;

        // 2. Now we have our left, reverse sublist until we get to the right node
        ListNode cur = prevLeft.next;
        for (int i = left; i < right; i++) {
            // For each node after left, we are going to "detach" from the list and place it after prev

            // First, detach
            ListNode reverse = cur.next;
            cur.next = reverse.next;

            // Then, attach
            reverse.next = prevLeft.next;
            prevLeft.next = reverse;
        }

        return newHead.next;
    }
}