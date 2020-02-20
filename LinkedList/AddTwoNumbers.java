package LinkedList;

import utils.ListUtil;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode curr = head;
		int carryover = 0;
		// Iterate till both are null
		while (l1 != null || l2 != null) {
			int val1 = l1 == null ? 0 : l1.val;
			int val2 = l2 == null ? 0 : l2.val;

			/**
			 * Below snippet can be replaced as the following:
			 * int digit = (val1 + val2 + carryover) % 10;
			 * carryover = (val1 + val2 + carryover) / 10;
			 */
			int digit = val1 + val2 + carryover;
			carryover = 0;
			if (digit >= 10) {
				carryover = 1;
				digit -= 10;
			}


			ListNode newNode = new ListNode(digit);
			curr.next = newNode;
			curr = newNode;

			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		if (carryover > 0) curr.next = new ListNode(1);
		return head.next;
	}

	/**
	 *
	 * This was my initial approach.
	 * The problem is that l1, l2 and currNode will still point to its original ListNode (or its head)
	 * 		even after an initial execution of processTwoLists.
	 * So it will eventually override currNode and will mess up what has been already processed.
	 *
	 * public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	 * 		// Determining first digit after addition and see if there's carryover
	 * 		int digit = l1.val + l2.val;
	 * 		boolean hasCarryover = false;
	 * 		if (digit >= 10) {
	 * 			hasCarryover = true;
	 * 			digit -= 10;
	 *                }
	 *
	 * 		// Defining head of the ListNode for a resulting List
	 * 		ListNode headNode = new ListNode(digit);
	 * 		ListNode currNode = headNode;
	 *
	 * 		l1 = l1.next;
	 * 		l2 = l2.next;
	 * 		processTwoLists(l1, l2, currNode, hasCarryover);
	 * 		// calling processTwoLists again in case l2 has greater length than l1
	 * 		processTwoLists(l2, l1, currNode, hasCarryover);
	 * 		return headNode;* 	}
	 *
	 * 	private static void processTwoLists(ListNode l1, ListNode l2, ListNode currNode, boolean hasCarryOver) {
	 * 		while (l1 != null) {
	 * 			// Figuring out a digit by first adding l1's value and considering carryover
	 * 			int digit = l1.val;
	 * 			if (hasCarryOver) {
	 * 				digit += 1;
	 * 				hasCarryOver = false;
	 *            }
	 *
	 * 			// Add l2's value if non-null
	 * 			if (l2 != null) {
	 * 				digit += l2.val;
	 * 				l2 = l2.next;
	 *            }
	 *
	 * 			// Update digit and carryover if applicable
	 * 			if (digit >= 10) {
	 * 				hasCarryOver = true;
	 * 				digit -= 10;
	 *            }
	 *
	 * 			ListNode newNode = new ListNode(digit);
	 * 			currNode.next = newNode;
	 * 			currNode = newNode;
	 *
	 * 			l1 = l1.next;
	 *        }
	 *    }
	 */

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		ListNode temp = l1;
		temp.next = new ListNode(8);
		//temp = temp.next;
		//temp.next = new ListNode(3);

		ListNode l2 = new ListNode(1);
		//temp = l2;
		//temp.next = new ListNode(6);
		//temp = temp.next;
		//temp.next = new ListNode(4);

		ListNode result = addTwoNumbers(l1, l2);
		System.out.println(result);
	}
}
