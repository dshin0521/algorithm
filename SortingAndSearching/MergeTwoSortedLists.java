package SortingAndSearching;

import pojo.ListNode;
import utils.ListNodeUtil;

/**
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example 1:
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 *
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode tempNode1 = l1;
        ListNode tempNode2 = l2;

        ListNode mergedList = null;
        ListNode tempNode3 = null;

        while (tempNode1 != null && tempNode2 != null) {
            if (tempNode1.val <= tempNode2.val) {
                if (mergedList == null) {
                    mergedList = tempNode1;
                    tempNode3 = mergedList;
                } else {
                    tempNode3.next = tempNode1;
                    tempNode3 = tempNode3.next;
                }
                tempNode1 = tempNode1.next;
            } else {
                if (mergedList == null) {
                    mergedList = tempNode2;
                    tempNode3 = mergedList;
                } else {
                    tempNode3.next = tempNode2;
                    tempNode3 = tempNode3.next;
                }
                tempNode2 = tempNode2.next;
            }
        }

        if (tempNode1 != null) tempNode3.next = tempNode1;
        if (tempNode2 != null) tempNode3.next = tempNode2;
        return mergedList;
    }

    public static ListNode mergeTwoListsCleanerSolution(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode preHead = new ListNode(0);
        ListNode last = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                last.next = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                l2 = l2.next;
            }
            last = last.next;
        }

        if (l1 != null) last.next = l1;
        if (l2 != null) last.next = l2;
        return preHead.next;
    }

    public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode list;
        if (l1.val <= l2.val) {
           list = l1;
           l1 = l1.next;
        } else {
            list = l2;
            l2 = l2.next;
        }
        ListNode ptr = list;
        mergeTwoListsRecursive(l1, l2, ptr);
        return list;
    }

    private static void mergeTwoListsRecursive(ListNode l1, ListNode l2, ListNode ptr) {
        if (l1 == null) {
            ptr.next = l2;
            return;
        }
        if (l2 == null) {
            ptr.next = l1;
            return;
        }

        if (l1.val <= l2.val) {
            ptr.next = l1;
            l1 = l1.next;
        } else {
            ptr.next = l2;
            l2 = l2.next;
        }
        ptr = ptr.next;

        mergeTwoListsRecursive(l1, l2, ptr);
    }

    public static ListNode mergeTwoListsRecursiveCleanerSolution(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoListsRecursiveCleanerSolution(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoListsRecursiveCleanerSolution(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {
        ListNode testList1 = ListNodeUtil.createList(new Integer[]{1,2,4});
        ListNode testList2 = ListNodeUtil.createList(new Integer[]{1,3,4});
        ListNodeUtil.printListNode(mergeTwoLists(testList1, testList2));

        testList1 = ListNodeUtil.createList(new Integer[]{1,2,4});
        testList2 = ListNodeUtil.createList(new Integer[]{1,3,4});
        ListNodeUtil.printListNode(mergeTwoListsCleanerSolution(testList1, testList2));

        testList1 = ListNodeUtil.createList(new Integer[]{1,2,4});
        testList2 = ListNodeUtil.createList(new Integer[]{1,3,4});
        ListNodeUtil.printListNode(mergeTwoListsRecursive(testList1, testList2));

        testList1 = ListNodeUtil.createList(new Integer[]{1,2,4});
        testList2 = ListNodeUtil.createList(new Integer[]{1,3,4});
        ListNodeUtil.printListNode(mergeTwoListsRecursiveCleanerSolution(testList1, testList2));
    }
}
