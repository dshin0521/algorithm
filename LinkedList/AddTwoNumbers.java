package LinkedList;

import pojo.ListNode;
import utils.ListNodeUtil;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode firstListPtr = l1;
        ListNode secondListPtr = l2;
        int carryOver = 0;

        ListNode resultList = null;
        ListNode resultListPtr = null;

        while (firstListPtr != null || secondListPtr != null) {

            int firstListVal = 0;
            if (firstListPtr != null) {
                firstListVal = firstListPtr.val;
                firstListPtr = firstListPtr.next;
            }

            int secondListVal = 0;
            if (secondListPtr != null) {
                secondListVal = secondListPtr.val;
                secondListPtr = secondListPtr.next;
            }

            int sum = firstListVal + secondListVal + carryOver;
            carryOver = sum / 10;
            sum = sum % 10;

            /**
             * We can get rid of below if/else block.
             * A method can start by,
             * 		ListNode resultList = new ListNode(-1);
             * 		ListNode resultListPtr = resultList;
             * and before returning the list it can,
             * 		return resultList.next;
             * No unnecessary if check and simpler.
             */
            if (resultList == null) {
                resultList = new ListNode(sum);
                resultListPtr = resultList;
            } else {
                resultListPtr.next = new ListNode(sum);
                resultListPtr = resultListPtr.next;
            }
        }
        if (carryOver != 0) {
            resultListPtr.next = new ListNode(1);
        }
        return resultList;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        ListNodeUtil.printListNode(result);

        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        result = addTwoNumbers(l1, l2);
        ListNodeUtil.printListNode(result);
    }
}
