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
    private ListNode mergeTwo(ListNode n1, ListNode n2) {
        ListNode sol = new ListNode();
        ListNode cur = sol;

        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                cur.next = n1;
                n1 = n1.next;
            }
            else {
                cur.next = n2;
                n2 = n2.next;
            }

            cur = cur.next;
        }

        if (n1 != null) cur.next = n1;
        else cur.next = n2;

        return sol.next;
    }

    private ListNode divide(ListNode[] lists, int l, int r) {
        if (l > r) return null;
        if (l == r) return lists[l]; // Only one remaining so don't need to merge

        // Otherwise, split and merge
        int m = (l + r) / 2;
        ListNode left = divide(lists, l, m);
        ListNode right = divide(lists, m + 1, r);

        return mergeTwo(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        

        // Two ways:
        // Merge each pair of lists until all lists are merged
            // Advantage: O(1) Space Complexity
        // for (int i = 1; i < lists.length; i++) {
        //     lists[i] = mergeTwo(lists[i], lists[i - 1]);
        // }

        // return lists[lists.length - 1];

        // // Heap of lists
        //     // Faster – O(nlogk)
        // PriorityQueue<ListNode> pq = new PriorityQueue<>(
        //     (a,b) -> a.val - b.val
        // );
        // for (ListNode list : lists) {
        //     if (list != null) pq.add(list);
        // }

        // ListNode sol = new ListNode();
        // ListNode cur = sol;
        // while (!pq.isEmpty()) {
        //     // Add the ListNode
        //     ListNode node = pq.poll();
        //     cur.next = node;
        //     cur = cur.next;

        //     // Move list onwards
        //     if (node.next != null) {
        //         pq.add(node.next);
        //     }
        // }
        // return sol.next;

        // Best way: Divide and Conquer
            // O(nlogk) runtime + O(logk) space
        if (lists == null || lists.length == 0) return null;
        return divide(lists, 0, lists.length - 1);
    }
}
