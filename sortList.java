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
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: If the list is empty or has only one node, it's already sorted.
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find the middle of the list to split it into two halves.
        // We use the fast and slow pointer approach.
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break the list into two halves.
        // 'prev' is the node before the middle, so we set its next pointer to null.
        if (prev != null) {
            prev.next = null;
        }

        // Step 2: Recursively sort the two halves.
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);

        // Step 3: Merge the two sorted halves.
        return merge(list1, list2);
    }

    // Helper function to merge two sorted linked lists.
    private ListNode merge(ListNode list1, ListNode list2) {
        // Create a dummy node to act as the head of the merged list.
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists and append the smaller node to the merged list.
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Append any remaining nodes from either list.
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        // The head of the merged list is the node after the dummy node.
        return dummy.next;
    }
}
