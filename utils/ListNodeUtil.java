package utils;

import pojo.ListNode;

public class ListNodeUtil {
    private static final String EMPTY_SPACE = " ";
    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";

    public static void printListNode(ListNode head) {
        if (head == null) {
            System.out.println(OPENING_BRACKET + EMPTY_SPACE + CLOSING_BRACKET);
            return;
        }
        System.out.print(OPENING_BRACKET + EMPTY_SPACE);
        while (head != null) {
            System.out.print(head.val + EMPTY_SPACE);
            head = head.next;
        }
        System.out.println(CLOSING_BRACKET);
    }
}
