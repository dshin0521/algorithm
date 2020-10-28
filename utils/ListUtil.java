package utils;

import java.util.List;

public class ListUtil {
    private static final String EMPTY_SPACE = " ";
    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";

    public static <T> void printList(List<T> listOfList) {
        if (listOfList == null || listOfList.isEmpty()) {
            System.out.println(OPENING_BRACKET + CLOSING_BRACKET);
            return;
        }
        System.out.print(OPENING_BRACKET + EMPTY_SPACE);
        for (T elem : listOfList) {
            if (elem instanceof List && !((List) elem).isEmpty() && ((List) elem).get(0) instanceof List) {
                printList((List)elem);
            } else {
                System.out.print(elem.toString() + EMPTY_SPACE);
            }
        }
        System.out.println(CLOSING_BRACKET + EMPTY_SPACE);
    }
}
