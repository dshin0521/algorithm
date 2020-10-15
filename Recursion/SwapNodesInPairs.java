package Recursion;

import pojo.ListNode;
import utils.ListNodeUtil;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes. Only nodes itself may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Example 2:
 * Input: head = []
 * Output: []
 *
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        swapPairs(null, head);
        return newHead;
    }

    private static void swapPairs(ListNode prev, ListNode curr) {
        if (curr == null || curr.next == null) return;
        ListNode temp = curr.next;
        curr.next = temp.next;
        temp.next = curr;
        if (prev != null) {
            prev.next = temp;
        }
        swapPairs(curr, curr.next);
    }

    public static void main(String[] args) {

        ListNode testHead = new ListNode();
        ListNode newHead = swapPairs(testHead);
        ListNodeUtil.printListNode(newHead);

        testHead = new ListNode(1);
        newHead = swapPairs(testHead);
        ListNodeUtil.printListNode(newHead);

        testHead = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        newHead = swapPairs(testHead);
        ListNodeUtil.printListNode(newHead);

    }
}
